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
public final class LightsServiceGrpc {

  private LightsServiceGrpc() {}

  public static final String SERVICE_NAME = "smarthome.LightsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.BooleanRequest,
      io.grpc.project.smarthome.lights.StringResponse> getLightSwitchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lightSwitch",
      requestType = io.grpc.project.smarthome.lights.BooleanRequest.class,
      responseType = io.grpc.project.smarthome.lights.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.BooleanRequest,
      io.grpc.project.smarthome.lights.StringResponse> getLightSwitchMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.BooleanRequest, io.grpc.project.smarthome.lights.StringResponse> getLightSwitchMethod;
    if ((getLightSwitchMethod = LightsServiceGrpc.getLightSwitchMethod) == null) {
      synchronized (LightsServiceGrpc.class) {
        if ((getLightSwitchMethod = LightsServiceGrpc.getLightSwitchMethod) == null) {
          LightsServiceGrpc.getLightSwitchMethod = getLightSwitchMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.lights.BooleanRequest, io.grpc.project.smarthome.lights.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.LightsService", "lightSwitch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.BooleanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightsServiceMethodDescriptorSupplier("lightSwitch"))
                  .build();
          }
        }
     }
     return getLightSwitchMethod;
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
    if ((getDisplayLightModesMethod = LightsServiceGrpc.getDisplayLightModesMethod) == null) {
      synchronized (LightsServiceGrpc.class) {
        if ((getDisplayLightModesMethod = LightsServiceGrpc.getDisplayLightModesMethod) == null) {
          LightsServiceGrpc.getDisplayLightModesMethod = getDisplayLightModesMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.lights.StringRequest, io.grpc.project.smarthome.lights.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.LightsService", "displayLightModes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.StringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightsServiceMethodDescriptorSupplier("displayLightModes"))
                  .build();
          }
        }
     }
     return getDisplayLightModesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.Modes,
      io.grpc.project.smarthome.lights.StringResponse> getSetLightModeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setLightMode",
      requestType = io.grpc.project.smarthome.lights.Modes.class,
      responseType = io.grpc.project.smarthome.lights.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.Modes,
      io.grpc.project.smarthome.lights.StringResponse> getSetLightModeMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.lights.Modes, io.grpc.project.smarthome.lights.StringResponse> getSetLightModeMethod;
    if ((getSetLightModeMethod = LightsServiceGrpc.getSetLightModeMethod) == null) {
      synchronized (LightsServiceGrpc.class) {
        if ((getSetLightModeMethod = LightsServiceGrpc.getSetLightModeMethod) == null) {
          LightsServiceGrpc.getSetLightModeMethod = getSetLightModeMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.lights.Modes, io.grpc.project.smarthome.lights.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.LightsService", "setLightMode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.Modes.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightsServiceMethodDescriptorSupplier("setLightMode"))
                  .build();
          }
        }
     }
     return getSetLightModeMethod;
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
    if ((getLightCombinerMethod = LightsServiceGrpc.getLightCombinerMethod) == null) {
      synchronized (LightsServiceGrpc.class) {
        if ((getLightCombinerMethod = LightsServiceGrpc.getLightCombinerMethod) == null) {
          LightsServiceGrpc.getLightCombinerMethod = getLightCombinerMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.lights.StringRequest, io.grpc.project.smarthome.lights.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.LightsService", "lightCombiner"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.StringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.lights.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightsServiceMethodDescriptorSupplier("lightCombiner"))
                  .build();
          }
        }
     }
     return getLightCombinerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightsServiceStub newStub(io.grpc.Channel channel) {
    return new LightsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightsServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LightsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void lightSwitch(io.grpc.project.smarthome.lights.BooleanRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLightSwitchMethod(), responseObserver);
    }

    /**
     */
    public void displayLightModes(io.grpc.project.smarthome.lights.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDisplayLightModesMethod(), responseObserver);
    }

    /**
     */
    public void setLightMode(io.grpc.project.smarthome.lights.Modes request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetLightModeMethod(), responseObserver);
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
            getLightSwitchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.project.smarthome.lights.BooleanRequest,
                io.grpc.project.smarthome.lights.StringResponse>(
                  this, METHODID_LIGHT_SWITCH)))
          .addMethod(
            getDisplayLightModesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                io.grpc.project.smarthome.lights.StringRequest,
                io.grpc.project.smarthome.lights.StringResponse>(
                  this, METHODID_DISPLAY_LIGHT_MODES)))
          .addMethod(
            getSetLightModeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.project.smarthome.lights.Modes,
                io.grpc.project.smarthome.lights.StringResponse>(
                  this, METHODID_SET_LIGHT_MODE)))
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
  public static final class LightsServiceStub extends io.grpc.stub.AbstractStub<LightsServiceStub> {
    private LightsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightsServiceStub(channel, callOptions);
    }

    /**
     */
    public void lightSwitch(io.grpc.project.smarthome.lights.BooleanRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLightSwitchMethod(), getCallOptions()), request, responseObserver);
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
    public void setLightMode(io.grpc.project.smarthome.lights.Modes request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetLightModeMethod(), getCallOptions()), request, responseObserver);
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
  public static final class LightsServiceBlockingStub extends io.grpc.stub.AbstractStub<LightsServiceBlockingStub> {
    private LightsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.project.smarthome.lights.StringResponse lightSwitch(io.grpc.project.smarthome.lights.BooleanRequest request) {
      return blockingUnaryCall(
          getChannel(), getLightSwitchMethod(), getCallOptions(), request);
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
    public io.grpc.project.smarthome.lights.StringResponse setLightMode(io.grpc.project.smarthome.lights.Modes request) {
      return blockingUnaryCall(
          getChannel(), getSetLightModeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LightsServiceFutureStub extends io.grpc.stub.AbstractStub<LightsServiceFutureStub> {
    private LightsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.project.smarthome.lights.StringResponse> lightSwitch(
        io.grpc.project.smarthome.lights.BooleanRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLightSwitchMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.project.smarthome.lights.StringResponse> setLightMode(
        io.grpc.project.smarthome.lights.Modes request) {
      return futureUnaryCall(
          getChannel().newCall(getSetLightModeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIGHT_SWITCH = 0;
  private static final int METHODID_DISPLAY_LIGHT_MODES = 1;
  private static final int METHODID_SET_LIGHT_MODE = 2;
  private static final int METHODID_LIGHT_COMBINER = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIGHT_SWITCH:
          serviceImpl.lightSwitch((io.grpc.project.smarthome.lights.BooleanRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse>) responseObserver);
          break;
        case METHODID_DISPLAY_LIGHT_MODES:
          serviceImpl.displayLightModes((io.grpc.project.smarthome.lights.StringRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.lights.StringResponse>) responseObserver);
          break;
        case METHODID_SET_LIGHT_MODE:
          serviceImpl.setLightMode((io.grpc.project.smarthome.lights.Modes) request,
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

  private static abstract class LightsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.project.smarthome.lights.LightsServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightsService");
    }
  }

  private static final class LightsServiceFileDescriptorSupplier
      extends LightsServiceBaseDescriptorSupplier {
    LightsServiceFileDescriptorSupplier() {}
  }

  private static final class LightsServiceMethodDescriptorSupplier
      extends LightsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LightsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightsServiceFileDescriptorSupplier())
              .addMethod(getLightSwitchMethod())
              .addMethod(getDisplayLightModesMethod())
              .addMethod(getSetLightModeMethod())
              .addMethod(getLightCombinerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
