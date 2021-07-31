package services;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import sample.Generator;
import stubs.*;
import stubs.LaptopServiceGrpc.LaptopServiceBlockingStub;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LaptopClient {
  private static final Logger logger = Logger.getLogger(LaptopClient.class.getName());

  private final ManagedChannel channel;
  private final LaptopServiceBlockingStub blockingStub;

  public LaptopClient(String host, int port) {
    channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    blockingStub = LaptopServiceGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown();
    if(!channel.awaitTermination(30, TimeUnit.SECONDS)){
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
      while (responseIterator.hasNext()){
        SearchLaptopResponse response = responseIterator.next();
        Laptop laptop = response.getLaptop();
        logger.info("- found: " + laptop.getId());
      }
      logger.info("Search Completed");
    }catch (Exception e){
      logger.severe("request failed: " + e.getMessage());
    }
  }

  public static void main(String[] args) throws InterruptedException {
    LaptopClient client = new LaptopClient("0.0.0.0", 8080);

    Generator generator = new Generator();

    try {
      for (int i=0; i<10; i++){
        Laptop laptop = generator.newLaptop();
        client.createLaptop(laptop);
      }
      Memory minRam = Memory.newBuilder().setValue(0).setUnit(Memory.Unit.GIGABYTE).build();
      Filter filter = Filter.newBuilder().setMaxPriceUsd(3000).setMinCpuCores(4).setMinCpuGhz(2.5).setMinRam(minRam).build();
      client.searchLaptop(filter);
    } finally {
      client.shutdown();
    }
  }
}
