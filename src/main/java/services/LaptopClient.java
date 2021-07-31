package services;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import sample.Generator;
import stubs.*;
import stubs.LaptopServiceGrpc.LaptopServiceBlockingStub;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LaptopClient {
  private static final Logger logger = Logger.getLogger(LaptopClient.class.getName());

  private final ManagedChannel channel;
  private final LaptopServiceBlockingStub blockingStub;
  private final LaptopServiceGrpc.LaptopServiceStub asyncStub;

  public LaptopClient(String host, int port) {
    channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    blockingStub = LaptopServiceGrpc.newBlockingStub(channel);
    asyncStub = LaptopServiceGrpc.newStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown();
    if (!channel.awaitTermination(30, TimeUnit.SECONDS)) {
      channel.shutdownNow();
    }
  }

  public void createLaptop(Laptop laptop) {
    CreateLaptopRequest request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();
    CreateLaptopResponse response = CreateLaptopResponse.getDefaultInstance();

    try {
      response = blockingStub.withDeadlineAfter(5, TimeUnit.SECONDS).createLaptop(request);
    } catch (StatusRuntimeException e) {
      if (e.getStatus().getCode() == Status.Code.ALREADY_EXISTS) {
        logger.info("Laptop ID already exists");
        return;
      }
      logger.severe("Request failed statusRuntime: " + e.getMessage());
      return;
    } catch (Exception e) {
      logger.severe("Request failed exception: " + e.getMessage());
      return;
    }

    logger.info("Laptop created with ID: " + response.getId());
  }

  private void searchLaptop(Filter filter) {
    logger.info("Search started");
    SearchLaptopRequest request = SearchLaptopRequest.newBuilder().setFilter(filter).build();
    try {
      Iterator<SearchLaptopResponse> responseIterator = blockingStub.withDeadlineAfter(5, TimeUnit.SECONDS).searchLaptop(request);
      while (responseIterator.hasNext()) {
        SearchLaptopResponse response = responseIterator.next();
        Laptop laptop = response.getLaptop();
        logger.info("- found: " + laptop.getId());
      }
      logger.info("Search Completed");
    } catch (Exception e) {
      logger.severe("request failed: " + e.getMessage());
    }
  }

  public void uploadImage(String laptopID, String imagePath) throws InterruptedException {
    final CountDownLatch finishLatch = new CountDownLatch(1);
    StreamObserver<UploadImageRequest> requestObserver = asyncStub.withDeadlineAfter(5, TimeUnit.SECONDS)
        .uploadImage(new StreamObserver<UploadImageResponse>() {
          @Override
          public void onNext(UploadImageResponse response) {
            logger.info("receive response:\n" + response);
          }

          @Override
          public void onError(Throwable t) {
            logger.log(Level.SEVERE, "upload failed: " + t);
            finishLatch.countDown();
          }

          @Override
          public void onCompleted() {
            logger.info("image uploaded");
            finishLatch.countDown();
          }
        });

    FileInputStream fileInputStream;
    try {
      fileInputStream = new FileInputStream(imagePath);
    } catch (FileNotFoundException e) {
      logger.log(Level.SEVERE, "cannot read image file: " + e.getMessage());
      return;
    }

    String imageType = imagePath.substring(imagePath.lastIndexOf("."));
    ImageInfo info = ImageInfo.newBuilder().setLaptopId(laptopID).setImageType(imageType).build();
    UploadImageRequest request = UploadImageRequest.newBuilder().setInfo(info).build();

    try {
      requestObserver.onNext(request);
      logger.info("sent image info:\n" + info);

      byte[] buffer = new byte[1024];
      while (true) {
        int n = fileInputStream.read(buffer);
        if (n <= 0) {
          break;
        }

        if (finishLatch.getCount() == 0) {
          return;
        }

        request = UploadImageRequest.newBuilder()
            .setChunkData(ByteString.copyFrom(buffer, 0, n))
            .build();
        requestObserver.onNext(request);
        logger.info("sent image chunk with size: " + n);
      }
    } catch (Exception e) {
      logger.log(Level.SEVERE, "unexpected error: " + e.getMessage());
      requestObserver.onError(e);
      return;
    }

    requestObserver.onCompleted();

    if (!finishLatch.await(1, TimeUnit.MINUTES)) {
      logger.warning("request cannot finish within 1 minute");
    }
  }

  public static void testCreateLaptop(LaptopClient client, Generator generator) {
    Laptop laptop = generator.newLaptop();
    client.createLaptop(laptop);
  }

  public static void testSearchLaptop(LaptopClient client, Generator generator) {
    for (int i = 0; i < 10; i++) {
      Laptop laptop = generator.newLaptop();
      client.createLaptop(laptop);
    }
    Memory minRam = Memory.newBuilder().setValue(0).setUnit(Memory.Unit.GIGABYTE).build();
    Filter filter = Filter.newBuilder().setMaxPriceUsd(3000).setMinCpuCores(4).setMinCpuGhz(2.5).setMinRam(minRam).build();
    client.searchLaptop(filter);
  }

  public static void testUploadImage(LaptopClient client, Generator generator) throws InterruptedException {
    Laptop laptop = generator.newLaptop();
    client.createLaptop(laptop);
    client.uploadImage(laptop.getId(), "tmp/vietnamese_girl.jpg");
  }

  public static void main(String[] args) throws InterruptedException {
    LaptopClient client = new LaptopClient("0.0.0.0", 8080);
    Generator generator = new Generator();

    try {
      testUploadImage(client, generator);
    } finally {
      client.shutdown();
    }
  }
}
