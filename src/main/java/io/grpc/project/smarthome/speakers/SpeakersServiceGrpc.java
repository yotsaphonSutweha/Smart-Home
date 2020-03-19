package io.grpc.project.smarthome.speakers;

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
    comments = "Source: speakers.proto")
public final class SpeakersServiceGrpc {

  private SpeakersServiceGrpc() {}

  public static final String SERVICE_NAME = "smarthome.SpeakersService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.speakers.StringRequest,
      io.grpc.project.smarthome.speakers.StringResponse> getTurnOnSpeakersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "turnOnSpeakers",
      requestType = io.grpc.project.smarthome.speakers.StringRequest.class,
      responseType = io.grpc.project.smarthome.speakers.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.speakers.StringRequest,
      io.grpc.project.smarthome.speakers.StringResponse> getTurnOnSpeakersMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.speakers.StringRequest, io.grpc.project.smarthome.speakers.StringResponse> getTurnOnSpeakersMethod;
    if ((getTurnOnSpeakersMethod = SpeakersServiceGrpc.getTurnOnSpeakersMethod) == null) {
      synchronized (SpeakersServiceGrpc.class) {
        if ((getTurnOnSpeakersMethod = SpeakersServiceGrpc.getTurnOnSpeakersMethod) == null) {
          SpeakersServiceGrpc.getTurnOnSpeakersMethod = getTurnOnSpeakersMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.speakers.StringRequest, io.grpc.project.smarthome.speakers.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.SpeakersService", "turnOnSpeakers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.speakers.StringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.speakers.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SpeakersServiceMethodDescriptorSupplier("turnOnSpeakers"))
                  .build();
          }
        }
     }
     return getTurnOnSpeakersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SpeakersServiceStub newStub(io.grpc.Channel channel) {
    return new SpeakersServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SpeakersServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SpeakersServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SpeakersServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SpeakersServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SpeakersServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void turnOnSpeakers(io.grpc.project.smarthome.speakers.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.speakers.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTurnOnSpeakersMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTurnOnSpeakersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.project.smarthome.speakers.StringRequest,
                io.grpc.project.smarthome.speakers.StringResponse>(
                  this, METHODID_TURN_ON_SPEAKERS)))
          .build();
    }
  }

  /**
   */
  public static final class SpeakersServiceStub extends io.grpc.stub.AbstractStub<SpeakersServiceStub> {
    private SpeakersServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpeakersServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeakersServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpeakersServiceStub(channel, callOptions);
    }

    /**
     */
    public void turnOnSpeakers(io.grpc.project.smarthome.speakers.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.speakers.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTurnOnSpeakersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SpeakersServiceBlockingStub extends io.grpc.stub.AbstractStub<SpeakersServiceBlockingStub> {
    private SpeakersServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpeakersServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeakersServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpeakersServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.project.smarthome.speakers.StringResponse turnOnSpeakers(io.grpc.project.smarthome.speakers.StringRequest request) {
      return blockingUnaryCall(
          getChannel(), getTurnOnSpeakersMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SpeakersServiceFutureStub extends io.grpc.stub.AbstractStub<SpeakersServiceFutureStub> {
    private SpeakersServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpeakersServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpeakersServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpeakersServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.project.smarthome.speakers.StringResponse> turnOnSpeakers(
        io.grpc.project.smarthome.speakers.StringRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTurnOnSpeakersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TURN_ON_SPEAKERS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SpeakersServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SpeakersServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TURN_ON_SPEAKERS:
          serviceImpl.turnOnSpeakers((io.grpc.project.smarthome.speakers.StringRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.speakers.StringResponse>) responseObserver);
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

  private static abstract class SpeakersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SpeakersServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.project.smarthome.speakers.SpeakersServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SpeakersService");
    }
  }

  private static final class SpeakersServiceFileDescriptorSupplier
      extends SpeakersServiceBaseDescriptorSupplier {
    SpeakersServiceFileDescriptorSupplier() {}
  }

  private static final class SpeakersServiceMethodDescriptorSupplier
      extends SpeakersServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SpeakersServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SpeakersServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SpeakersServiceFileDescriptorSupplier())
              .addMethod(getTurnOnSpeakersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
