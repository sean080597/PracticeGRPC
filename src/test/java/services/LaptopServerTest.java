package services;

import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.Generator;
import stubs.CreateLaptopRequest;
import stubs.CreateLaptopResponse;
import stubs.Laptop;
import stubs.LaptopServiceGrpc;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LaptopServerTest {
  @Rule
  public final GrpcCleanupRule grpcCleanupRule = new GrpcCleanupRule();

  private LaptopStore store;
  private LaptopServer server;
  private ManagedChannel channel;

  @BeforeEach
  void setUp() throws IOException {
    String serverName = InProcessServerBuilder.generateName();
    InProcessServerBuilder serverBuilder = InProcessServerBuilder.forName(serverName).directExecutor();

    store = new InMemoryLaptopStore();
    server = new LaptopServer(serverBuilder, 0, store);
    server.start();

    channel = grpcCleanupRule.register(
        InProcessChannelBuilder.forName(serverName).directExecutor().build()
    );
  }

  @AfterEach
  void tearDown() throws InterruptedException {
    server.stop();
  }

  @Test
  public void createLaptopWithValidID(){
    Generator generator = new Generator();
    Laptop laptop = generator.newLaptop();
    CreateLaptopRequest request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();

    LaptopServiceGrpc.LaptopServiceBlockingStub stub = LaptopServiceGrpc.newBlockingStub(channel);
    CreateLaptopResponse response = stub.createLaptop(request);
    assertNotNull(response);
    assertEquals(laptop.getId(), response.getId());

    Laptop found = store.find(response.getId());
    assertNotNull(found);
  }

  @Test
  public void createLaptopWithEmptyID(){
    Generator generator = new Generator();
    Laptop laptop = generator.newLaptop().toBuilder().setId("").build();
    CreateLaptopRequest request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();

    LaptopServiceGrpc.LaptopServiceBlockingStub stub = LaptopServiceGrpc.newBlockingStub(channel);
    CreateLaptopResponse response = stub.createLaptop(request);
    assertNotNull(response);
    assertFalse(response.getId().isEmpty());

    Laptop found = store.find(response.getId());
    assertNotNull(found);
  }

  @Test
  public void createLaptopWithInvalidID(){
    Generator generator = new Generator();
    Laptop laptop = generator.newLaptop().toBuilder().setId("invalid").build();
    CreateLaptopRequest request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();

    LaptopServiceGrpc.LaptopServiceBlockingStub stub = LaptopServiceGrpc.newBlockingStub(channel);
    CreateLaptopResponse response = stub.createLaptop(request);
    assertThrows(StatusRuntimeException.class, () -> {});
  }

  @Test
  public void createLaptopWithAlreadyExistsID() throws Exception {
    Generator generator = new Generator();
    Laptop laptop = generator.newLaptop();
    store.save(laptop);
    CreateLaptopRequest request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();

    LaptopServiceGrpc.LaptopServiceBlockingStub stub = LaptopServiceGrpc.newBlockingStub(channel);
    CreateLaptopResponse response = stub.createLaptop(request);
    assertThrows(StatusRuntimeException.class, () -> {});
  }
}