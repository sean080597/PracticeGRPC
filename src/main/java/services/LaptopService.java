package services;

import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import stubs.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class LaptopService extends LaptopServiceGrpc.LaptopServiceImplBase {
  private static final Logger logger = Logger.getLogger(LaptopService.class.getName());

  private LaptopStore store;

  public LaptopService(LaptopStore store) {
    this.store = store;
  }

  @Override
  public void createLaptop(CreateLaptopRequest request, StreamObserver<CreateLaptopResponse> responseObserver) {
    Laptop laptop = request.getLaptop();

    String id = laptop.getId();
    logger.info("Got a created-laptop request with id: " + id);

    UUID uuid;
    if (id.isEmpty()) {
      uuid = UUID.randomUUID();
    } else {
      try {
        uuid = UUID.fromString(id);
      } catch (IllegalArgumentException e) {
        responseObserver.onError(
            Status.INVALID_ARGUMENT
                .withDescription(e.getMessage())
                .asRuntimeException()
        );
        return;
      }
    }

//    // heavy processing
//    try {
//      TimeUnit.SECONDS.sleep(6);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }

    if (Context.current().isCancelled()) {
      logger.info("Request is cancelled");
      responseObserver.onError(
          Status.CANCELLED
              .withDescription("Request is cancelled")
              .asRuntimeException()
      );
      return;
    }

    Laptop other = laptop.toBuilder().setId(uuid.toString()).build();
    try {
      store.save(other);
    } catch (AlreadyExistsException e) {
      responseObserver.onError(
          Status.ALREADY_EXISTS
              .withDescription(e.getMessage())
              .asRuntimeException()
      );
      return;
    } catch (Exception e) {
      responseObserver.onError(
          Status.INTERNAL
              .withDescription(e.getMessage())
              .asRuntimeException()
      );
      return;
    }

    CreateLaptopResponse response = CreateLaptopResponse.newBuilder().setId(other.getId()).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();

    logger.info("Saved laptop with ID: " + other.getId());
  }

  @Override
  public void searchLaptop(SearchLaptopRequest request, StreamObserver<SearchLaptopResponse> responseObserver) {
    Filter filter = request.getFilter();
    logger.info("Got a search-laptop request with filter:\n" + filter);

    store.Search(Context.current(), filter, new LaptopStream() {
      @Override
      public void Send(Laptop laptop) {
        logger.info("Found laptop with ID: " + laptop.getId());
        SearchLaptopResponse response = SearchLaptopResponse.newBuilder().setLaptop(laptop).build();
        responseObserver.onNext(response);
      }
    });

    responseObserver.onCompleted();
    logger.info("Search laptop completed");
  }
}
