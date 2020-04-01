package io.grpc.project.smarthome.curtain;

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
    comments = "Source: curtain.proto")
public final class CurtainServiceGrpc {

  private CurtainServiceGrpc() {}

  public static final String SERVICE_NAME = "CurtainService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.curtain.StringRequest,
      io.grpc.project.smarthome.curtain.StringResponse> getOpenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "open",
      requestType = io.grpc.project.smarthome.curtain.StringRequest.class,
      responseType = io.grpc.project.smarthome.curtain.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.curtain.StringRequest,
      io.grpc.project.smarthome.curtain.StringResponse> getOpenMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.curtain.StringRequest, io.grpc.project.smarthome.curtain.StringResponse> getOpenMethod;
    if ((getOpenMethod = CurtainServiceGrpc.getOpenMethod) == null) {
      synchronized (CurtainServiceGrpc.class) {
        if ((getOpenMethod = CurtainServiceGrpc.getOpenMethod) == null) {
          CurtainServiceGrpc.getOpenMethod = getOpenMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.curtain.StringRequest, io.grpc.project.smarthome.curtain.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CurtainService", "open"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.curtain.StringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.curtain.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CurtainServiceMethodDescriptorSupplier("open"))
                  .build();
          }
        }
     }
     return getOpenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.curtain.StringRequest,
      io.grpc.project.smarthome.curtain.StringResponse> getCloseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "close",
      requestType = io.grpc.project.smarthome.curtain.StringRequest.class,
      responseType = io.grpc.project.smarthome.curtain.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.curtain.StringRequest,
      io.grpc.project.smarthome.curtain.StringResponse> getCloseMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.curtain.StringRequest, io.grpc.project.smarthome.curtain.StringResponse> getCloseMethod;
    if ((getCloseMethod = CurtainServiceGrpc.getCloseMethod) == null) {
      synchronized (CurtainServiceGrpc.class) {
        if ((getCloseMethod = CurtainServiceGrpc.getCloseMethod) == null) {
          CurtainServiceGrpc.getCloseMethod = getCloseMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.curtain.StringRequest, io.grpc.project.smarthome.curtain.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CurtainService", "close"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.curtain.StringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.curtain.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CurtainServiceMethodDescriptorSupplier("close"))
                  .build();
          }
        }
     }
     return getCloseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.curtain.HeightAndWidth,
      io.grpc.project.smarthome.curtain.StringResponse> getAdjustHeightAndWidthMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "adjustHeightAndWidth",
      requestType = io.grpc.project.smarthome.curtain.HeightAndWidth.class,
      responseType = io.grpc.project.smarthome.curtain.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.curtain.HeightAndWidth,
      io.grpc.project.smarthome.curtain.StringResponse> getAdjustHeightAndWidthMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.curtain.HeightAndWidth, io.grpc.project.smarthome.curtain.StringResponse> getAdjustHeightAndWidthMethod;
    if ((getAdjustHeightAndWidthMethod = CurtainServiceGrpc.getAdjustHeightAndWidthMethod) == null) {
      synchronized (CurtainServiceGrpc.class) {
        if ((getAdjustHeightAndWidthMethod = CurtainServiceGrpc.getAdjustHeightAndWidthMethod) == null) {
          CurtainServiceGrpc.getAdjustHeightAndWidthMethod = getAdjustHeightAndWidthMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.curtain.HeightAndWidth, io.grpc.project.smarthome.curtain.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CurtainService", "adjustHeightAndWidth"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.curtain.HeightAndWidth.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.curtain.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CurtainServiceMethodDescriptorSupplier("adjustHeightAndWidth"))
                  .build();
          }
        }
     }
     return getAdjustHeightAndWidthMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CurtainServiceStub newStub(io.grpc.Channel channel) {
    return new CurtainServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CurtainServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CurtainServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CurtainServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CurtainServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CurtainServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void open(io.grpc.project.smarthome.curtain.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.curtain.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getOpenMethod(), responseObserver);
    }

    /**
     */
    public void close(io.grpc.project.smarthome.curtain.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.curtain.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCloseMethod(), responseObserver);
    }

    /**
     */
    public void adjustHeightAndWidth(io.grpc.project.smarthome.curtain.HeightAndWidth request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.curtain.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAdjustHeightAndWidthMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOpenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.project.smarthome.curtain.StringRequest,
                io.grpc.project.smarthome.curtain.StringResponse>(
                  this, METHODID_OPEN)))
          .addMethod(
            getCloseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.project.smarthome.curtain.StringRequest,
                io.grpc.project.smarthome.curtain.StringResponse>(
                  this, METHODID_CLOSE)))
          .addMethod(
            getAdjustHeightAndWidthMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.project.smarthome.curtain.HeightAndWidth,
                io.grpc.project.smarthome.curtain.StringResponse>(
                  this, METHODID_ADJUST_HEIGHT_AND_WIDTH)))
          .build();
    }
  }

  /**
   */
  public static final class CurtainServiceStub extends io.grpc.stub.AbstractStub<CurtainServiceStub> {
    private CurtainServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurtainServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurtainServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurtainServiceStub(channel, callOptions);
    }

    /**
     */
    public void open(io.grpc.project.smarthome.curtain.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.curtain.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOpenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void close(io.grpc.project.smarthome.curtain.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.curtain.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCloseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void adjustHeightAndWidth(io.grpc.project.smarthome.curtain.HeightAndWidth request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.curtain.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAdjustHeightAndWidthMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CurtainServiceBlockingStub extends io.grpc.stub.AbstractStub<CurtainServiceBlockingStub> {
    private CurtainServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurtainServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurtainServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurtainServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.project.smarthome.curtain.StringResponse open(io.grpc.project.smarthome.curtain.StringRequest request) {
      return blockingUnaryCall(
          getChannel(), getOpenMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.project.smarthome.curtain.StringResponse close(io.grpc.project.smarthome.curtain.StringRequest request) {
      return blockingUnaryCall(
          getChannel(), getCloseMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.project.smarthome.curtain.StringResponse adjustHeightAndWidth(io.grpc.project.smarthome.curtain.HeightAndWidth request) {
      return blockingUnaryCall(
          getChannel(), getAdjustHeightAndWidthMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CurtainServiceFutureStub extends io.grpc.stub.AbstractStub<CurtainServiceFutureStub> {
    private CurtainServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurtainServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurtainServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurtainServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.project.smarthome.curtain.StringResponse> open(
        io.grpc.project.smarthome.curtain.StringRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getOpenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.project.smarthome.curtain.StringResponse> close(
        io.grpc.project.smarthome.curtain.StringRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCloseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.project.smarthome.curtain.StringResponse> adjustHeightAndWidth(
        io.grpc.project.smarthome.curtain.HeightAndWidth request) {
      return futureUnaryCall(
          getChannel().newCall(getAdjustHeightAndWidthMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_OPEN = 0;
  private static final int METHODID_CLOSE = 1;
  private static final int METHODID_ADJUST_HEIGHT_AND_WIDTH = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CurtainServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CurtainServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OPEN:
          serviceImpl.open((io.grpc.project.smarthome.curtain.StringRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.curtain.StringResponse>) responseObserver);
          break;
        case METHODID_CLOSE:
          serviceImpl.close((io.grpc.project.smarthome.curtain.StringRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.curtain.StringResponse>) responseObserver);
          break;
        case METHODID_ADJUST_HEIGHT_AND_WIDTH:
          serviceImpl.adjustHeightAndWidth((io.grpc.project.smarthome.curtain.HeightAndWidth) request,
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.curtain.StringResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CurtainServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CurtainServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.project.smarthome.curtain.CurtainServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CurtainService");
    }
  }

  private static final class CurtainServiceFileDescriptorSupplier
      extends CurtainServiceBaseDescriptorSupplier {
    CurtainServiceFileDescriptorSupplier() {}
  }

  private static final class CurtainServiceMethodDescriptorSupplier
      extends CurtainServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CurtainServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CurtainServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CurtainServiceFileDescriptorSupplier())
              .addMethod(getOpenMethod())
              .addMethod(getCloseMethod())
              .addMethod(getAdjustHeightAndWidthMethod())
              .build();
        }
      }
    }
    return result;
  }
}
