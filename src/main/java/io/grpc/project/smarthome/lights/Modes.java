// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lights.proto

package io.grpc.project.smarthome.lights;

/**
 * Protobuf type {@code smarthome.Modes}
 */
public  final class Modes extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:smarthome.Modes)
    ModesOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Modes.newBuilder() to construct.
  private Modes(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Modes() {
    detail_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Modes(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {
            int rawValue = input.readEnum();

            detail_ = rawValue;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.grpc.project.smarthome.lights.LightsServiceImpl.internal_static_smarthome_Modes_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.grpc.project.smarthome.lights.LightsServiceImpl.internal_static_smarthome_Modes_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.grpc.project.smarthome.lights.Modes.class, io.grpc.project.smarthome.lights.Modes.Builder.class);
  }

  /**
   * Protobuf enum {@code smarthome.Modes.Mode}
   */
  public enum Mode
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>LIGHT = 0;</code>
     */
    LIGHT(0),
    /**
     * <code>DARK = 1;</code>
     */
    DARK(1),
    /**
     * <code>DISCO = 2;</code>
     */
    DISCO(2),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>LIGHT = 0;</code>
     */
    public static final int LIGHT_VALUE = 0;
    /**
     * <code>DARK = 1;</code>
     */
    public static final int DARK_VALUE = 1;
    /**
     * <code>DISCO = 2;</code>
     */
    public static final int DISCO_VALUE = 2;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static Mode valueOf(int value) {
      return forNumber(value);
    }

    public static Mode forNumber(int value) {
      switch (value) {
        case 0: return LIGHT;
        case 1: return DARK;
        case 2: return DISCO;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Mode>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Mode> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Mode>() {
            public Mode findValueByNumber(int number) {
              return Mode.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return io.grpc.project.smarthome.lights.Modes.getDescriptor().getEnumTypes().get(0);
    }

    private static final Mode[] VALUES = values();

    public static Mode valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Mode(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:smarthome.Modes.Mode)
  }

  public static final int DETAIL_FIELD_NUMBER = 1;
  private int detail_;
  /**
   * <code>.smarthome.Modes.Mode detail = 1;</code>
   */
  public int getDetailValue() {
    return detail_;
  }
  /**
   * <code>.smarthome.Modes.Mode detail = 1;</code>
   */
  public io.grpc.project.smarthome.lights.Modes.Mode getDetail() {
    @SuppressWarnings("deprecation")
    io.grpc.project.smarthome.lights.Modes.Mode result = io.grpc.project.smarthome.lights.Modes.Mode.valueOf(detail_);
    return result == null ? io.grpc.project.smarthome.lights.Modes.Mode.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (detail_ != io.grpc.project.smarthome.lights.Modes.Mode.LIGHT.getNumber()) {
      output.writeEnum(1, detail_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (detail_ != io.grpc.project.smarthome.lights.Modes.Mode.LIGHT.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, detail_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.grpc.project.smarthome.lights.Modes)) {
      return super.equals(obj);
    }
    io.grpc.project.smarthome.lights.Modes other = (io.grpc.project.smarthome.lights.Modes) obj;

    boolean result = true;
    result = result && detail_ == other.detail_;
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + DETAIL_FIELD_NUMBER;
    hash = (53 * hash) + detail_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.grpc.project.smarthome.lights.Modes parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.project.smarthome.lights.Modes parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.project.smarthome.lights.Modes parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.project.smarthome.lights.Modes parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.project.smarthome.lights.Modes parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.project.smarthome.lights.Modes parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.project.smarthome.lights.Modes parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.project.smarthome.lights.Modes parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.project.smarthome.lights.Modes parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.grpc.project.smarthome.lights.Modes parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.project.smarthome.lights.Modes parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.project.smarthome.lights.Modes parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.grpc.project.smarthome.lights.Modes prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code smarthome.Modes}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:smarthome.Modes)
      io.grpc.project.smarthome.lights.ModesOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.grpc.project.smarthome.lights.LightsServiceImpl.internal_static_smarthome_Modes_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.grpc.project.smarthome.lights.LightsServiceImpl.internal_static_smarthome_Modes_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.grpc.project.smarthome.lights.Modes.class, io.grpc.project.smarthome.lights.Modes.Builder.class);
    }

    // Construct using io.grpc.project.smarthome.lights.Modes.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      detail_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.grpc.project.smarthome.lights.LightsServiceImpl.internal_static_smarthome_Modes_descriptor;
    }

    @java.lang.Override
    public io.grpc.project.smarthome.lights.Modes getDefaultInstanceForType() {
      return io.grpc.project.smarthome.lights.Modes.getDefaultInstance();
    }

    @java.lang.Override
    public io.grpc.project.smarthome.lights.Modes build() {
      io.grpc.project.smarthome.lights.Modes result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.grpc.project.smarthome.lights.Modes buildPartial() {
      io.grpc.project.smarthome.lights.Modes result = new io.grpc.project.smarthome.lights.Modes(this);
      result.detail_ = detail_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.grpc.project.smarthome.lights.Modes) {
        return mergeFrom((io.grpc.project.smarthome.lights.Modes)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.grpc.project.smarthome.lights.Modes other) {
      if (other == io.grpc.project.smarthome.lights.Modes.getDefaultInstance()) return this;
      if (other.detail_ != 0) {
        setDetailValue(other.getDetailValue());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.grpc.project.smarthome.lights.Modes parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.grpc.project.smarthome.lights.Modes) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int detail_ = 0;
    /**
     * <code>.smarthome.Modes.Mode detail = 1;</code>
     */
    public int getDetailValue() {
      return detail_;
    }
    /**
     * <code>.smarthome.Modes.Mode detail = 1;</code>
     */
    public Builder setDetailValue(int value) {
      detail_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.smarthome.Modes.Mode detail = 1;</code>
     */
    public io.grpc.project.smarthome.lights.Modes.Mode getDetail() {
      @SuppressWarnings("deprecation")
      io.grpc.project.smarthome.lights.Modes.Mode result = io.grpc.project.smarthome.lights.Modes.Mode.valueOf(detail_);
      return result == null ? io.grpc.project.smarthome.lights.Modes.Mode.UNRECOGNIZED : result;
    }
    /**
     * <code>.smarthome.Modes.Mode detail = 1;</code>
     */
    public Builder setDetail(io.grpc.project.smarthome.lights.Modes.Mode value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      detail_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.smarthome.Modes.Mode detail = 1;</code>
     */
    public Builder clearDetail() {
      
      detail_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:smarthome.Modes)
  }

  // @@protoc_insertion_point(class_scope:smarthome.Modes)
  private static final io.grpc.project.smarthome.lights.Modes DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.grpc.project.smarthome.lights.Modes();
  }

  public static io.grpc.project.smarthome.lights.Modes getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Modes>
      PARSER = new com.google.protobuf.AbstractParser<Modes>() {
    @java.lang.Override
    public Modes parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Modes(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Modes> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Modes> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.grpc.project.smarthome.lights.Modes getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

