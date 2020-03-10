package io.grpc.project.smarthome;

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
    comments = "Source: smarthome.proto")
public final class SmartHomeServiceGrpc {

  private SmartHomeServiceGrpc() {}

  public static final String SERVICE_NAME = "smarthome.SmartHomeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.StringRequest,
      io.grpc.project.smarthome.StringResponse> getMakeConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "makeConnection",
      requestType = io.grpc.project.smarthome.StringRequest.class,
      responseType = io.grpc.project.smarthome.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.StringRequest,
      io.grpc.project.smarthome.StringResponse> getMakeConnectionMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.StringRequest, io.grpc.project.smarthome.StringResponse> getMakeConnectionMethod;
    if ((getMakeConnectionMethod = SmartHomeServiceGrpc.getMakeConnectionMethod) == null) {
      synchronized (SmartHomeServiceGrpc.class) {
        if ((getMakeConnectionMethod = SmartHomeServiceGrpc.getMakeConnectionMethod) == null) {
          SmartHomeServiceGrpc.getMakeConnectionMethod = getMakeConnectionMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.StringRequest, io.grpc.project.smarthome.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.SmartHomeService", "makeConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.StringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartHomeServiceMethodDescriptorSupplier("makeConnection"))
                  .build();
          }
        }
     }
     return getMakeConnectionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartHomeServiceStub newStub(io.grpc.Channel channel) {
    return new SmartHomeServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartHomeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartHomeServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartHomeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartHomeServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SmartHomeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void makeConnection(io.grpc.project.smarthome.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMakeConnectionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMakeConnectionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.project.smarthome.StringRequest,
                io.grpc.project.smarthome.StringResponse>(
                  this, METHODID_MAKE_CONNECTION)))
          .build();
    }
  }

  /**
   */
  public static final class SmartHomeServiceStub extends io.grpc.stub.AbstractStub<SmartHomeServiceStub> {
    private SmartHomeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartHomeServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartHomeServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartHomeServiceStub(channel, callOptions);
    }

    /**
     */
    public void makeConnection(io.grpc.project.smarthome.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMakeConnectionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SmartHomeServiceBlockingStub extends io.grpc.stub.AbstractStub<SmartHomeServiceBlockingStub> {
    private SmartHomeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartHomeServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartHomeServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartHomeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.project.smarthome.StringResponse makeConnection(io.grpc.project.smarthome.StringRequest request) {
      return blockingUnaryCall(
          getChannel(), getMakeConnectionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SmartHomeServiceFutureStub extends io.grpc.stub.AbstractStub<SmartHomeServiceFutureStub> {
    private SmartHomeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartHomeServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartHomeServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartHomeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.project.smarthome.StringResponse> makeConnection(
        io.grpc.project.smarthome.StringRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMakeConnectionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MAKE_CONNECTION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartHomeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartHomeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MAKE_CONNECTION:
          serviceImpl.makeConnection((io.grpc.project.smarthome.StringRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.StringResponse>) responseObserver);
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

  private static abstract class SmartHomeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartHomeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.project.smarthome.SmartHomeServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartHomeService");
    }
  }

  private static final class SmartHomeServiceFileDescriptorSupplier
      extends SmartHomeServiceBaseDescriptorSupplier {
    SmartHomeServiceFileDescriptorSupplier() {}
  }

  private static final class SmartHomeServiceMethodDescriptorSupplier
      extends SmartHomeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartHomeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SmartHomeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartHomeServiceFileDescriptorSupplier())
              .addMethod(getMakeConnectionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
