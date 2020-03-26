package io.grpc.project.smarthome.tv;

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
    comments = "Source: tv.proto")
public final class TvServiceGrpc {

  private TvServiceGrpc() {}

  public static final String SERVICE_NAME = "smarthome.TvService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.BooleanRequest,
      io.grpc.project.smarthome.tv.StringResponse> getTurnOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "turnOn",
      requestType = io.grpc.project.smarthome.tv.BooleanRequest.class,
      responseType = io.grpc.project.smarthome.tv.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.BooleanRequest,
      io.grpc.project.smarthome.tv.StringResponse> getTurnOnMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.BooleanRequest, io.grpc.project.smarthome.tv.StringResponse> getTurnOnMethod;
    if ((getTurnOnMethod = TvServiceGrpc.getTurnOnMethod) == null) {
      synchronized (TvServiceGrpc.class) {
        if ((getTurnOnMethod = TvServiceGrpc.getTurnOnMethod) == null) {
          TvServiceGrpc.getTurnOnMethod = getTurnOnMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.tv.BooleanRequest, io.grpc.project.smarthome.tv.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.TvService", "turnOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.tv.BooleanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.tv.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TvServiceMethodDescriptorSupplier("turnOn"))
                  .build();
          }
        }
     }
     return getTurnOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.StringRequest,
      io.grpc.project.smarthome.tv.StringResponse> getDisplayChannelListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "displayChannelList",
      requestType = io.grpc.project.smarthome.tv.StringRequest.class,
      responseType = io.grpc.project.smarthome.tv.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.StringRequest,
      io.grpc.project.smarthome.tv.StringResponse> getDisplayChannelListMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.StringRequest, io.grpc.project.smarthome.tv.StringResponse> getDisplayChannelListMethod;
    if ((getDisplayChannelListMethod = TvServiceGrpc.getDisplayChannelListMethod) == null) {
      synchronized (TvServiceGrpc.class) {
        if ((getDisplayChannelListMethod = TvServiceGrpc.getDisplayChannelListMethod) == null) {
          TvServiceGrpc.getDisplayChannelListMethod = getDisplayChannelListMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.tv.StringRequest, io.grpc.project.smarthome.tv.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.TvService", "displayChannelList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.tv.StringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.tv.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TvServiceMethodDescriptorSupplier("displayChannelList"))
                  .build();
          }
        }
     }
     return getDisplayChannelListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.IntRequest,
      io.grpc.project.smarthome.tv.IntResponse> getIncreaseVolumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "increaseVolume",
      requestType = io.grpc.project.smarthome.tv.IntRequest.class,
      responseType = io.grpc.project.smarthome.tv.IntResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.IntRequest,
      io.grpc.project.smarthome.tv.IntResponse> getIncreaseVolumeMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.IntRequest, io.grpc.project.smarthome.tv.IntResponse> getIncreaseVolumeMethod;
    if ((getIncreaseVolumeMethod = TvServiceGrpc.getIncreaseVolumeMethod) == null) {
      synchronized (TvServiceGrpc.class) {
        if ((getIncreaseVolumeMethod = TvServiceGrpc.getIncreaseVolumeMethod) == null) {
          TvServiceGrpc.getIncreaseVolumeMethod = getIncreaseVolumeMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.tv.IntRequest, io.grpc.project.smarthome.tv.IntResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.TvService", "increaseVolume"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.tv.IntRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.tv.IntResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TvServiceMethodDescriptorSupplier("increaseVolume"))
                  .build();
          }
        }
     }
     return getIncreaseVolumeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.StringRequest,
      io.grpc.project.smarthome.tv.StringResponse> getLiveContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "liveContent",
      requestType = io.grpc.project.smarthome.tv.StringRequest.class,
      responseType = io.grpc.project.smarthome.tv.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.StringRequest,
      io.grpc.project.smarthome.tv.StringResponse> getLiveContentMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.StringRequest, io.grpc.project.smarthome.tv.StringResponse> getLiveContentMethod;
    if ((getLiveContentMethod = TvServiceGrpc.getLiveContentMethod) == null) {
      synchronized (TvServiceGrpc.class) {
        if ((getLiveContentMethod = TvServiceGrpc.getLiveContentMethod) == null) {
          TvServiceGrpc.getLiveContentMethod = getLiveContentMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.tv.StringRequest, io.grpc.project.smarthome.tv.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.TvService", "liveContent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.tv.StringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.tv.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TvServiceMethodDescriptorSupplier("liveContent"))
                  .build();
          }
        }
     }
     return getLiveContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.StringRequest,
      io.grpc.project.smarthome.tv.StringResponse> getDisplayInputsSpeakersCommandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "displayInputsSpeakersCommand",
      requestType = io.grpc.project.smarthome.tv.StringRequest.class,
      responseType = io.grpc.project.smarthome.tv.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.StringRequest,
      io.grpc.project.smarthome.tv.StringResponse> getDisplayInputsSpeakersCommandMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.StringRequest, io.grpc.project.smarthome.tv.StringResponse> getDisplayInputsSpeakersCommandMethod;
    if ((getDisplayInputsSpeakersCommandMethod = TvServiceGrpc.getDisplayInputsSpeakersCommandMethod) == null) {
      synchronized (TvServiceGrpc.class) {
        if ((getDisplayInputsSpeakersCommandMethod = TvServiceGrpc.getDisplayInputsSpeakersCommandMethod) == null) {
          TvServiceGrpc.getDisplayInputsSpeakersCommandMethod = getDisplayInputsSpeakersCommandMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.tv.StringRequest, io.grpc.project.smarthome.tv.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.TvService", "displayInputsSpeakersCommand"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.tv.StringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.tv.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TvServiceMethodDescriptorSupplier("displayInputsSpeakersCommand"))
                  .build();
          }
        }
     }
     return getDisplayInputsSpeakersCommandMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.StringRequest,
      io.grpc.project.smarthome.tv.StringResponse> getMusicStreamingSpeakersCommandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "musicStreamingSpeakersCommand",
      requestType = io.grpc.project.smarthome.tv.StringRequest.class,
      responseType = io.grpc.project.smarthome.tv.StringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.StringRequest,
      io.grpc.project.smarthome.tv.StringResponse> getMusicStreamingSpeakersCommandMethod() {
    io.grpc.MethodDescriptor<io.grpc.project.smarthome.tv.StringRequest, io.grpc.project.smarthome.tv.StringResponse> getMusicStreamingSpeakersCommandMethod;
    if ((getMusicStreamingSpeakersCommandMethod = TvServiceGrpc.getMusicStreamingSpeakersCommandMethod) == null) {
      synchronized (TvServiceGrpc.class) {
        if ((getMusicStreamingSpeakersCommandMethod = TvServiceGrpc.getMusicStreamingSpeakersCommandMethod) == null) {
          TvServiceGrpc.getMusicStreamingSpeakersCommandMethod = getMusicStreamingSpeakersCommandMethod = 
              io.grpc.MethodDescriptor.<io.grpc.project.smarthome.tv.StringRequest, io.grpc.project.smarthome.tv.StringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smarthome.TvService", "musicStreamingSpeakersCommand"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.tv.StringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.project.smarthome.tv.StringResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TvServiceMethodDescriptorSupplier("musicStreamingSpeakersCommand"))
                  .build();
          }
        }
     }
     return getMusicStreamingSpeakersCommandMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TvServiceStub newStub(io.grpc.Channel channel) {
    return new TvServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TvServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TvServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TvServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TvServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TvServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void turnOn(io.grpc.project.smarthome.tv.BooleanRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTurnOnMethod(), responseObserver);
    }

    /**
     */
    public void displayChannelList(io.grpc.project.smarthome.tv.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDisplayChannelListMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.IntRequest> increaseVolume(
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.IntResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getIncreaseVolumeMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringRequest> liveContent(
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getLiveContentMethod(), responseObserver);
    }

    /**
     */
    public void displayInputsSpeakersCommand(io.grpc.project.smarthome.tv.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDisplayInputsSpeakersCommandMethod(), responseObserver);
    }

    /**
     */
    public void musicStreamingSpeakersCommand(io.grpc.project.smarthome.tv.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMusicStreamingSpeakersCommandMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTurnOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.project.smarthome.tv.BooleanRequest,
                io.grpc.project.smarthome.tv.StringResponse>(
                  this, METHODID_TURN_ON)))
          .addMethod(
            getDisplayChannelListMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                io.grpc.project.smarthome.tv.StringRequest,
                io.grpc.project.smarthome.tv.StringResponse>(
                  this, METHODID_DISPLAY_CHANNEL_LIST)))
          .addMethod(
            getIncreaseVolumeMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                io.grpc.project.smarthome.tv.IntRequest,
                io.grpc.project.smarthome.tv.IntResponse>(
                  this, METHODID_INCREASE_VOLUME)))
          .addMethod(
            getLiveContentMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.grpc.project.smarthome.tv.StringRequest,
                io.grpc.project.smarthome.tv.StringResponse>(
                  this, METHODID_LIVE_CONTENT)))
          .addMethod(
            getDisplayInputsSpeakersCommandMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.project.smarthome.tv.StringRequest,
                io.grpc.project.smarthome.tv.StringResponse>(
                  this, METHODID_DISPLAY_INPUTS_SPEAKERS_COMMAND)))
          .addMethod(
            getMusicStreamingSpeakersCommandMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.project.smarthome.tv.StringRequest,
                io.grpc.project.smarthome.tv.StringResponse>(
                  this, METHODID_MUSIC_STREAMING_SPEAKERS_COMMAND)))
          .build();
    }
  }

  /**
   */
  public static final class TvServiceStub extends io.grpc.stub.AbstractStub<TvServiceStub> {
    private TvServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TvServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TvServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TvServiceStub(channel, callOptions);
    }

    /**
     */
    public void turnOn(io.grpc.project.smarthome.tv.BooleanRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTurnOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void displayChannelList(io.grpc.project.smarthome.tv.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getDisplayChannelListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.IntRequest> increaseVolume(
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.IntResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getIncreaseVolumeMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringRequest> liveContent(
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getLiveContentMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void displayInputsSpeakersCommand(io.grpc.project.smarthome.tv.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDisplayInputsSpeakersCommandMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void musicStreamingSpeakersCommand(io.grpc.project.smarthome.tv.StringRequest request,
        io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMusicStreamingSpeakersCommandMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TvServiceBlockingStub extends io.grpc.stub.AbstractStub<TvServiceBlockingStub> {
    private TvServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TvServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TvServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TvServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.project.smarthome.tv.StringResponse turnOn(io.grpc.project.smarthome.tv.BooleanRequest request) {
      return blockingUnaryCall(
          getChannel(), getTurnOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<io.grpc.project.smarthome.tv.StringResponse> displayChannelList(
        io.grpc.project.smarthome.tv.StringRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getDisplayChannelListMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.project.smarthome.tv.StringResponse displayInputsSpeakersCommand(io.grpc.project.smarthome.tv.StringRequest request) {
      return blockingUnaryCall(
          getChannel(), getDisplayInputsSpeakersCommandMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.project.smarthome.tv.StringResponse musicStreamingSpeakersCommand(io.grpc.project.smarthome.tv.StringRequest request) {
      return blockingUnaryCall(
          getChannel(), getMusicStreamingSpeakersCommandMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TvServiceFutureStub extends io.grpc.stub.AbstractStub<TvServiceFutureStub> {
    private TvServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TvServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TvServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TvServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.project.smarthome.tv.StringResponse> turnOn(
        io.grpc.project.smarthome.tv.BooleanRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTurnOnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.project.smarthome.tv.StringResponse> displayInputsSpeakersCommand(
        io.grpc.project.smarthome.tv.StringRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDisplayInputsSpeakersCommandMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.project.smarthome.tv.StringResponse> musicStreamingSpeakersCommand(
        io.grpc.project.smarthome.tv.StringRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMusicStreamingSpeakersCommandMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TURN_ON = 0;
  private static final int METHODID_DISPLAY_CHANNEL_LIST = 1;
  private static final int METHODID_DISPLAY_INPUTS_SPEAKERS_COMMAND = 2;
  private static final int METHODID_MUSIC_STREAMING_SPEAKERS_COMMAND = 3;
  private static final int METHODID_INCREASE_VOLUME = 4;
  private static final int METHODID_LIVE_CONTENT = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TvServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TvServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TURN_ON:
          serviceImpl.turnOn((io.grpc.project.smarthome.tv.BooleanRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse>) responseObserver);
          break;
        case METHODID_DISPLAY_CHANNEL_LIST:
          serviceImpl.displayChannelList((io.grpc.project.smarthome.tv.StringRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse>) responseObserver);
          break;
        case METHODID_DISPLAY_INPUTS_SPEAKERS_COMMAND:
          serviceImpl.displayInputsSpeakersCommand((io.grpc.project.smarthome.tv.StringRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse>) responseObserver);
          break;
        case METHODID_MUSIC_STREAMING_SPEAKERS_COMMAND:
          serviceImpl.musicStreamingSpeakersCommand((io.grpc.project.smarthome.tv.StringRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse>) responseObserver);
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
        case METHODID_INCREASE_VOLUME:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.increaseVolume(
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.IntResponse>) responseObserver);
        case METHODID_LIVE_CONTENT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.liveContent(
              (io.grpc.stub.StreamObserver<io.grpc.project.smarthome.tv.StringResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TvServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TvServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.project.smarthome.tv.TvServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TvService");
    }
  }

  private static final class TvServiceFileDescriptorSupplier
      extends TvServiceBaseDescriptorSupplier {
    TvServiceFileDescriptorSupplier() {}
  }

  private static final class TvServiceMethodDescriptorSupplier
      extends TvServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TvServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TvServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TvServiceFileDescriptorSupplier())
              .addMethod(getTurnOnMethod())
              .addMethod(getDisplayChannelListMethod())
              .addMethod(getIncreaseVolumeMethod())
              .addMethod(getLiveContentMethod())
              .addMethod(getDisplayInputsSpeakersCommandMethod())
              .addMethod(getMusicStreamingSpeakersCommandMethod())
              .build();
        }
      }
    }
    return result;
  }
}
