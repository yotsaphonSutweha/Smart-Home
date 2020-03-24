package io.grpc.project.smarthome.lights;

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
    comments = "Source: lights.proto")
public final class SpeakersServiceGrpc {

  private SpeakersServiceGrpc() {}

  public static final String SERVICE_NAME = "smarthome.SpeakersService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.BooleanRequest,
      io.grpc.project.smarthome.lights.StringResponse> getLightSwithMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lightSwith",
      requestType = io.grpc.project.smarthome.lights.BooleanRequest.class,
      responseType = io.grpc.project.smarthome.lights.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.BooleanRequest,
      io.grpc.project.smarthome.lights.StringResponse> getLightSwithMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.BooleanRequest, io.grpc.project.smarthome.lights.StringResponse> getLightSwithMethod;
    if ((getLightSwithMethod = SpeakersServiceGrpc.getLightSwithMethod) == null) {
      synchronized (SpeakersServiceGrpc.class) {
        if ((getLightSwithMethod = SpeakersServiceGrpc.getLightSwithMethod) == null) {
          SpeakersServiceGrpc.getLightSwithMethod = getLightSwithMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.lights.BooleanRequest, io.grpc.project.smarthome.lights.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.SpeakersService", "lightSwith"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.BooleanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SpeakersServiceMethodDescriptorSupplier("lightSwith"))
                  .build();
          }
        }
     }
     return getLightSwithMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.StringRequest,
      io.grpc.project.smarthome.lights.StringResponse> getDisplayLightModesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "displayLightModes",
      requestType = io.grpc.project.smarthome.lights.StringRequest.class,
      responseType = io.grpc.project.smarthome.lights.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.StringRequest,
      io.grpc.project.smarthome.lights.StringResponse> getDisplayLightModesMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.StringRequest, io.grpc.project.smarthome.lights.StringResponse> getDisplayLightModesMethod;
    if ((getDisplayLightModesMethod = SpeakersServiceGrpc.getDisplayLightModesMethod) == null) {
      synchronized (SpeakersServiceGrpc.class) {
        if ((getDisplayLightModesMethod = SpeakersServiceGrpc.getDisplayLightModesMethod) == null) {
          SpeakersServiceGrpc.getDisplayLightModesMethod = getDisplayLightModesMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.lights.StringRequest, io.grpc.project.smarthome.lights.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.SpeakersService", "displayLightModes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.StringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SpeakersServiceMethodDescriptorSupplier("displayLightModes"))
                  .build();
          }
        }
     }
     return getDisplayLightModesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.Modes,
      io.grpc.project.smarthome.lights.StringResponse> getSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "set",
      requestType = io.grpc.project.smarthome.lights.Modes.class,
      responseType = io.grpc.project.smarthome.lights.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.Modes,
      io.grpc.project.smarthome.lights.StringResponse> getSetMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.Modes, io.grpc.project.smarthome.lights.StringResponse> getSetMethod;
    if ((getSetMethod = SpeakersServiceGrpc.getSetMethod) == null) {
      synchronized (SpeakersServiceGrpc.class) {
        if ((getSetMethod = SpeakersServiceGrpc.getSetMethod) == null) {
          SpeakersServiceGrpc.getSetMethod = getSetMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.lights.Modes, io.grpc.project.smarthome.lights.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.SpeakersService", "set"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.Modes.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SpeakersServiceMethodDescriptorSupplier("set"))
                  .build();
          }
        }
     }
     return getSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.StringRequest,
      io.grpc.project.smarthome.lights.StringResponse> getLightCombinerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lightCombiner",
      requestType = io.grpc.project.smarthome.lights.StringRequest.class,
      responseType = io.grpc.project.smarthome.lights.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.StringRequest,
      io.grpc.project.smarthome.lights.StringResponse> getLightCombinerMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.StringRequest, io.grpc.project.smarthome.lights.StringResponse> getLightCombinerMethod;
    if ((getLightCombinerMethod = SpeakersServiceGrpc.getLightCombinerMethod) == null) {
      synchronized (SpeakersServiceGrpc.class) {
        if ((getLightCombinerMethod = SpeakersServiceGrpc.getLightCombinerMethod) == null) {
          SpeakersServiceGrpc.getLightCombinerMethod = getLightCombinerMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.lights.StringRequest, io.grpc.project.smarthome.lights.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.SpeakersService", "lightCombiner"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.StringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SpeakersServiceMethodDescriptorSupplier("lightCombiner"))
                  .build();
          }
        }
     }
     return getLightCombinerMethod;
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
    public void lightSwith(io.grpc.project.smarthome.lights.BooleanRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLightSwithMethod(), responseObserver);
    }

    /**
     */
    public void displayLightModes(io.grpc.project.smarthome.lights.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDisplayLightModesMethod(), responseObserver);
    }

    /**
     */
    public void set(io.grpc.project.smarthome.lights.Modes request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringRequest> lightCombiner(
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getLightCombinerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLightSwithMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.project.smarthome.lights.BooleanRequest,
                io.grpc.project.smarthome.lights.StringResponse>(
                  this, METHODID_LIGHT_SWITH)))
          .addMethod(
            getDisplayLightModesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                io.grpc.project.smarthome.lights.StringRequest,
                io.grpc.project.smarthome.lights.StringResponse>(
                  this, METHODID_DISPLAY_LIGHT_MODES)))
          .addMethod(
            getSetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.project.smarthome.lights.Modes,
                io.grpc.project.smarthome.lights.StringResponse>(
                  this, METHODID_SET)))
          .addMethod(
            getLightCombinerMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                io.grpc.project.smarthome.lights.StringRequest,
                io.grpc.project.smarthome.lights.StringResponse>(
                  this, METHODID_LIGHT_COMBINER)))
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
    public void lightSwith(io.grpc.project.smarthome.lights.BooleanRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLightSwithMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void displayLightModes(io.grpc.project.smarthome.lights.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getDisplayLightModesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void set(io.grpc.project.smarthome.lights.Modes request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringRequest> lightCombiner(
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getLightCombinerMethod(), getCallOptions()), responseObserver);
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
    public io.grpc.project.smarthome.lights.StringResponse lightSwith(io.grpc.project.smarthome.lights.BooleanRequest request) {
      return blockingUnaryCall(
          getChannel(), getLightSwithMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<io.grpc.project.smarthome.lights.StringResponse> displayLightModes(
        io.grpc.project.smarthome.lights.StringRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getDisplayLightModesMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.project.smarthome.lights.StringResponse set(io.grpc.project.smarthome.lights.Modes request) {
      return blockingUnaryCall(
          getChannel(), getSetMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.project.smarthome.lights.StringResponse> lightSwith(
        io.grpc.project.smarthome.lights.BooleanRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLightSwithMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.project.smarthome.lights.StringResponse> set(
        io.grpc.project.smarthome.lights.Modes request) {
      return futureUnaryCall(
          getChannel().newCall(getSetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIGHT_SWITH = 0;
  private static final int METHODID_DISPLAY_LIGHT_MODES = 1;
  private static final int METHODID_SET = 2;
  private static final int METHODID_LIGHT_COMBINER = 3;

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
        case METHODID_LIGHT_SWITH:
          serviceImpl.lightSwith((io.grpc.project.smarthome.lights.BooleanRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse>) responseObserver);
          break;
        case METHODID_DISPLAY_LIGHT_MODES:
          serviceImpl.displayLightModes((io.grpc.project.smarthome.lights.StringRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse>) responseObserver);
          break;
        case METHODID_SET:
          serviceImpl.set((io.grpc.project.smarthome.lights.Modes) request,
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse>) responseObserver);
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
        case METHODID_LIGHT_COMBINER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.lightCombiner(
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse>) responseObserver);
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
      return io.grpc.project.smarthome.lights.LightsServiceImpl.getDescriptor();
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
              .addMethod(getLightSwithMethod())
              .addMethod(getDisplayLightModesMethod())
              .addMethod(getSetMethod())
              .addMethod(getLightCombinerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
