// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: messaging_client.proto
// Protobuf Java Version: 4.26.0

package igl3;

public final class MessagingClientProto {
  private MessagingClientProto() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 0,
      /* suffix= */ "",
      MessagingClientProto.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messaging_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messaging_Message_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_messaging_GetMessagesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_messaging_GetMessagesRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026messaging_client.proto\022\tmessaging\"F\n\007M" +
      "essage\022\n\n\002id\030\001 \001(\t\022\016\n\006sender\030\002 \001(\t\022\021\n\tre" +
      "cipient\030\003 \001(\t\022\014\n\004text\030\004 \001(\t\"&\n\022GetMessag" +
      "esRequest\022\020\n\010username\030\001 \001(\t2\227\001\n\017Messagin" +
      "gClient\0227\n\013SendMessage\022\022.messaging.Messa" +
      "ge\032\022.messaging.Message\"\000\022K\n\022GetMessagesF" +
      "orUser\022\035.messaging.GetMessagesRequest\032\022." +
      "messaging.Message\"\0000\001B$\n\004igl3B\024Messaging" +
      "ClientProtoP\001\242\002\003HLWb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_messaging_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_messaging_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messaging_Message_descriptor,
        new java.lang.String[] { "Id", "Sender", "Recipient", "Text", });
    internal_static_messaging_GetMessagesRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_messaging_GetMessagesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_messaging_GetMessagesRequest_descriptor,
        new java.lang.String[] { "Username", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
