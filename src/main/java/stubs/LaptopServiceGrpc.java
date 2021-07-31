package stubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: laptop_service.proto")
public final class LaptopServiceGrpc {

  private LaptopServiceGrpc() {}

  public static final String SERVICE_NAME = "LaptopService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<stubs.CreateLaptopRequest,
      stubs.CreateLaptopResponse> getCreateLaptopMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLaptop",
      requestType = stubs.CreateLaptopRequest.class,
      responseType = stubs.CreateLaptopResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<stubs.CreateLaptopRequest,
      stubs.CreateLaptopResponse> getCreateLaptopMethod() {
    io.grpc.MethodDescriptor<stubs.CreateLaptopRequest, stubs.CreateLaptopResponse> getCreateLaptopMethod;
    if ((getCreateLaptopMethod = LaptopServiceGrpc.getCreateLaptopMethod) == null) {
      synchronized (LaptopServiceGrpc.class) {
        if ((getCreateLaptopMethod = LaptopServiceGrpc.getCreateLaptopMethod) == null) {
          LaptopServiceGrpc.getCreateLaptopMethod = getCreateLaptopMethod = 
              io.grpc.MethodDescriptor.<stubs.CreateLaptopRequest, stubs.CreateLaptopResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "LaptopService", "CreateLaptop"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stubs.CreateLaptopRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stubs.CreateLaptopResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LaptopServiceMethodDescriptorSupplier("CreateLaptop"))
                  .build();
          }
        }
     }
     return getCreateLaptopMethod;
  }

  private static volatile io.grpc.MethodDescriptor<stubs.SearchLaptopRequest,
      stubs.SearchLaptopResponse> getSearchLaptopMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchLaptop",
      requestType = stubs.SearchLaptopRequest.class,
      responseType = stubs.SearchLaptopResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<stubs.SearchLaptopRequest,
      stubs.SearchLaptopResponse> getSearchLaptopMethod() {
    io.grpc.MethodDescriptor<stubs.SearchLaptopRequest, stubs.SearchLaptopResponse> getSearchLaptopMethod;
    if ((getSearchLaptopMethod = LaptopServiceGrpc.getSearchLaptopMethod) == null) {
      synchronized (LaptopServiceGrpc.class) {
        if ((getSearchLaptopMethod = LaptopServiceGrpc.getSearchLaptopMethod) == null) {
          LaptopServiceGrpc.getSearchLaptopMethod = getSearchLaptopMethod = 
              io.grpc.MethodDescriptor.<stubs.SearchLaptopRequest, stubs.SearchLaptopResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "LaptopService", "SearchLaptop"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stubs.SearchLaptopRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stubs.SearchLaptopResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LaptopServiceMethodDescriptorSupplier("SearchLaptop"))
                  .build();
          }
        }
     }
     return getSearchLaptopMethod;
  }

  private static volatile io.grpc.MethodDescriptor<stubs.UploadImageRequest,
      stubs.UploadImageResponse> getUploadImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadImage",
      requestType = stubs.UploadImageRequest.class,
      responseType = stubs.UploadImageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<stubs.UploadImageRequest,
      stubs.UploadImageResponse> getUploadImageMethod() {
    io.grpc.MethodDescriptor<stubs.UploadImageRequest, stubs.UploadImageResponse> getUploadImageMethod;
    if ((getUploadImageMethod = LaptopServiceGrpc.getUploadImageMethod) == null) {
      synchronized (LaptopServiceGrpc.class) {
        if ((getUploadImageMethod = LaptopServiceGrpc.getUploadImageMethod) == null) {
          LaptopServiceGrpc.getUploadImageMethod = getUploadImageMethod = 
              io.grpc.MethodDescriptor.<stubs.UploadImageRequest, stubs.UploadImageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "LaptopService", "UploadImage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stubs.UploadImageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stubs.UploadImageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LaptopServiceMethodDescriptorSupplier("UploadImage"))
                  .build();
          }
        }
     }
     return getUploadImageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LaptopServiceStub newStub(io.grpc.Channel channel) {
    return new LaptopServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LaptopServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LaptopServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LaptopServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LaptopServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LaptopServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createLaptop(stubs.CreateLaptopRequest request,
        io.grpc.stub.StreamObserver<stubs.CreateLaptopResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateLaptopMethod(), responseObserver);
    }

    /**
     */
    public void searchLaptop(stubs.SearchLaptopRequest request,
        io.grpc.stub.StreamObserver<stubs.SearchLaptopResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchLaptopMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<stubs.UploadImageRequest> uploadImage(
        io.grpc.stub.StreamObserver<stubs.UploadImageResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getUploadImageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateLaptopMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                stubs.CreateLaptopRequest,
                stubs.CreateLaptopResponse>(
                  this, METHODID_CREATE_LAPTOP)))
          .addMethod(
            getSearchLaptopMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                stubs.SearchLaptopRequest,
                stubs.SearchLaptopResponse>(
                  this, METHODID_SEARCH_LAPTOP)))
          .addMethod(
            getUploadImageMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                stubs.UploadImageRequest,
                stubs.UploadImageResponse>(
                  this, METHODID_UPLOAD_IMAGE)))
          .build();
    }
  }

  /**
   */
  public static final class LaptopServiceStub extends io.grpc.stub.AbstractStub<LaptopServiceStub> {
    private LaptopServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LaptopServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LaptopServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LaptopServiceStub(channel, callOptions);
    }

    /**
     */
    public void createLaptop(stubs.CreateLaptopRequest request,
        io.grpc.stub.StreamObserver<stubs.CreateLaptopResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateLaptopMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchLaptop(stubs.SearchLaptopRequest request,
        io.grpc.stub.StreamObserver<stubs.SearchLaptopResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSearchLaptopMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<stubs.UploadImageRequest> uploadImage(
        io.grpc.stub.StreamObserver<stubs.UploadImageResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getUploadImageMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class LaptopServiceBlockingStub extends io.grpc.stub.AbstractStub<LaptopServiceBlockingStub> {
    private LaptopServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LaptopServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LaptopServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LaptopServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public stubs.CreateLaptopResponse createLaptop(stubs.CreateLaptopRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateLaptopMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<stubs.SearchLaptopResponse> searchLaptop(
        stubs.SearchLaptopRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSearchLaptopMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LaptopServiceFutureStub extends io.grpc.stub.AbstractStub<LaptopServiceFutureStub> {
    private LaptopServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LaptopServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LaptopServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LaptopServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<stubs.CreateLaptopResponse> createLaptop(
        stubs.CreateLaptopRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateLaptopMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_LAPTOP = 0;
  private static final int METHODID_SEARCH_LAPTOP = 1;
  private static final int METHODID_UPLOAD_IMAGE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LaptopServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LaptopServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_LAPTOP:
          serviceImpl.createLaptop((stubs.CreateLaptopRequest) request,
              (io.grpc.stub.StreamObserver<stubs.CreateLaptopResponse>) responseObserver);
          break;
        case METHODID_SEARCH_LAPTOP:
          serviceImpl.searchLaptop((stubs.SearchLaptopRequest) request,
              (io.grpc.stub.StreamObserver<stubs.SearchLaptopResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD_IMAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.uploadImage(
              (io.grpc.stub.StreamObserver<stubs.UploadImageResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LaptopServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LaptopServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return stubs.LaptopServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LaptopService");
    }
  }

  private static final class LaptopServiceFileDescriptorSupplier
      extends LaptopServiceBaseDescriptorSupplier {
    LaptopServiceFileDescriptorSupplier() {}
  }

  private static final class LaptopServiceMethodDescriptorSupplier
      extends LaptopServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LaptopServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LaptopServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LaptopServiceFileDescriptorSupplier())
              .addMethod(getCreateLaptopMethod())
              .addMethod(getSearchLaptopMethod())
              .addMethod(getUploadImageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
