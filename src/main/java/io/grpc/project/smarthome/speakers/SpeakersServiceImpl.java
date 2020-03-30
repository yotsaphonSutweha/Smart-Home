// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: speakers.proto

package io.grpc.project.smarthome.speakers;

public final class SpeakersServiceImpl {
  private SpeakersServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smarthome_StringRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smarthome_StringRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smarthome_StringResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smarthome_StringResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smarthome_BooleanRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smarthome_BooleanRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smarthome_IntRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smarthome_IntRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smarthome_IntResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smarthome_IntResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016speakers.proto\022\tsmarthome\"+\n\rStringReq" +
      "uest\022\032\n\022stringRequestValue\030\001 \001(\t\"-\n\016Stri" +
      "ngResponse\022\033\n\023stringResponseValue\030\001 \001(\t\"" +
      "-\n\016BooleanRequest\022\033\n\023booleanRequestValue" +
      "\030\001 \001(\010\"\036\n\nIntRequest\022\020\n\010numInput\030\001 \001(\005\" " +
      "\n\013IntResponse\022\021\n\tnumOutput\030\001 \001(\0052\261\002\n\017Spe" +
      "akersService\022H\n\016turnOnSpeakers\022\031.smartho" +
      "me.BooleanRequest\032\031.smarthome.StringResp" +
      "onse\"\000\022I\n\rdisplayInputs\022\031.smarthome.Bool" +
      "eanRequest\032\031.smarthome.StringResponse\"\0000" +
      "\001\022K\n\016musicStreaming\022\030.smarthome.StringRe" +
      "quest\032\031.smarthome.StringResponse\"\000(\0010\001\022<" +
      "\n\tsetVolume\022\025.smarthome.IntRequest\032\026.sma" +
      "rthome.IntResponse\"\000B;\n\"io.grpc.project." +
      "smarthome.speakersB\023SpeakersServiceImplP" +
      "\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_smarthome_StringRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_smarthome_StringRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smarthome_StringRequest_descriptor,
        new java.lang.String[] { "StringRequestValue", });
    internal_static_smarthome_StringResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_smarthome_StringResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smarthome_StringResponse_descriptor,
        new java.lang.String[] { "StringResponseValue", });
    internal_static_smarthome_BooleanRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_smarthome_BooleanRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smarthome_BooleanRequest_descriptor,
        new java.lang.String[] { "BooleanRequestValue", });
    internal_static_smarthome_IntRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_smarthome_IntRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smarthome_IntRequest_descriptor,
        new java.lang.String[] { "NumInput", });
    internal_static_smarthome_IntResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_smarthome_IntResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smarthome_IntResponse_descriptor,
        new java.lang.String[] { "NumOutput", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
