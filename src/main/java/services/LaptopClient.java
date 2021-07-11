package services;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import sample.Generator;
import stubs.CreateLaptopRequest;
import stubs.CreateLaptopResponse;
import stubs.Laptop;
import stubs.LaptopServiceGrpc;
import stubs.LaptopServiceGrpc.LaptopServiceBlockingStub;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LaptopClient {
  private static final Logger logger = Logger.getLogger(LaptopClient.class.toString());

  private final ManagedChannel channel;
  private final LaptopServiceBlockingStub blockingStub;

  public LaptopClient(String host, int port) {
    channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    blockingStub = LaptopServiceGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
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
      logger.severe("Request failed: " + e.getMessage());
      return;
    } catch (Exception e) {
      logger.severe("Request failed: " + e.getMessage());
      return;
    }

    logger.info("Laptop created with ID: " + response.getId());
  }

  public static void main(String[] args) throws InterruptedException {
    LaptopClient client = new LaptopClient("0.0.0.0", 8080);

    Generator generator = new Generator();
    Laptop laptop = generator.newLaptop();

    try {
      client.createLaptop(laptop);
    } finally {
      client.shutdown();
    }
  }
}
