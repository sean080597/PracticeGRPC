package services;

import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import sample.Generator;
import stubs.CreateLaptopRequest;
import stubs.CreateLaptopResponse;
import stubs.Laptop;
import stubs.LaptopServiceGrpc;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class LaptopServerTest {
  @Rule
  public final GrpcCleanupRule grpcCleanupRule = new GrpcCleanupRule();

  private LaptopStore laptopStore;
  private DiskImageStore imageStore;
  private InMemoryRatingStore ratingStore;
  private LaptopServer server;
  private ManagedChannel channel;

  @Before
  public void setUp() throws IOException {
    String serverName = InProcessServerBuilder.generateName();
    InProcessServerBuilder serverBuilder = InProcessServerBuilder.forName(serverName).directExecutor();

    laptopStore = new InMemoryLaptopStore();
    imageStore = new DiskImageStore("img");
    ratingStore = new InMemoryRatingStore();
    server = new LaptopServer(serverBuilder, 0, laptopStore, imageStore, ratingStore);
    server.start();

    channel = grpcCleanupRule.register(
        InProcessChannelBuilder.forName(serverName).directExecutor().build()
    );
  }

  @After
  public void tearDown() throws InterruptedException {
    server.stop();
  }

  @Test
  public void createLaptopWithValidID(){
    Generator generator = new Generator();
    Laptop laptop = generator.newLaptop();
    CreateLaptopRequest request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();

    LaptopServiceGrpc.LaptopServiceBlockingStub stub = LaptopServiceGrpc.newBlockingStub(channel);
    CreateLaptopResponse response = stub.createLaptop(request);
    assertThat(response).isNotNull();
    assertThat(laptop.getId()).isEqualTo(response.getId());

    Laptop found = laptopStore.find(response.getId());
    assertThat(found).isNotNull();
  }

  @Test
  public void createLaptopWithEmptyID(){
    Generator generator = new Generator();
    Laptop laptop = generator.newLaptop().toBuilder().setId("").build();
    CreateLaptopRequest request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();

    LaptopServiceGrpc.LaptopServiceBlockingStub stub = LaptopServiceGrpc.newBlockingStub(channel);
    CreateLaptopResponse response = stub.createLaptop(request);
    assertThat(response).isNotNull();
    assertThat(response.getId().isEmpty()).isFalse();

    Laptop found = laptopStore.find(response.getId());
    assertThat(found).isNotNull();
  }

  @Test(expected = StatusRuntimeException.class)
  public void createLaptopWithInvalidID(){
    Generator generator = new Generator();
    Laptop laptop = generator.newLaptop().toBuilder().setId("invalid").build();
    CreateLaptopRequest request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();

    LaptopServiceGrpc.LaptopServiceBlockingStub stub = LaptopServiceGrpc.newBlockingStub(channel);
    CreateLaptopResponse response = stub.createLaptop(request);
  }

  @Test(expected = StatusRuntimeException.class)
  public void createLaptopWithAlreadyExistsID() throws Exception {
    Generator generator = new Generator();
    Laptop laptop = generator.newLaptop();
    laptopStore.save(laptop);
    CreateLaptopRequest request = CreateLaptopRequest.newBuilder().setLaptop(laptop).build();

    LaptopServiceGrpc.LaptopServiceBlockingStub stub = LaptopServiceGrpc.newBlockingStub(channel);
    CreateLaptopResponse response = stub.createLaptop(request);
  }
}