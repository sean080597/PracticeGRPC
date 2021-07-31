package services;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class LaptopServer {
  private static final Logger logger = Logger.getLogger(LaptopServer.class.getName());

  private final int port;
  private final Server server;

  public LaptopServer(int port, LaptopStore store) {
    this(ServerBuilder.forPort(port), port, store);
  }

  public LaptopServer(ServerBuilder serverBuilder, int port, LaptopStore store) {
    this.port = port;
    LaptopService laptopService = new LaptopService(store);
    server = serverBuilder.addService(laptopService).build();
  }

  public void start() throws IOException {
    server.start();
    logger.info("Server started at port: " + port);

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        logger.info("Shutdown gRPC server because JVM shuts down");
        try {
          LaptopServer.this.stop();
        } catch (InterruptedException e) {
          e.printStackTrace(System.err);
        }
        System.err.println("Server shutdown");
      }
    });
  }

  public void stop() throws InterruptedException {
    if (server != null) {
      server.shutdown();
      if(!server.awaitTermination(30, TimeUnit.SECONDS)){
        server.shutdownNow();
      }
    }
  }

  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    InMemoryLaptopStore store = new InMemoryLaptopStore();
    LaptopServer server = new LaptopServer(8080, store);
    server.start();
    server.blockUntilShutdown();
  }
}
