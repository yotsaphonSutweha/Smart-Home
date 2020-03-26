# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: curtain.proto

from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='curtain.proto',
  package='',
  syntax='proto3',
  serialized_options=None,
  serialized_pb=b'\n\rcurtain.proto\"+\n\rStringRequest\x12\x1a\n\x12stringRequestValue\x18\x01 \x01(\t\"-\n\x0e\x42ooleanRequest\x12\x1b\n\x13\x62ooleanRequestValue\x18\x01 \x01(\x08\"-\n\x0eStringResponse\x12\x1b\n\x13stringResponseValue\x18\x01 \x01(\t\"/\n\x0eHeightAndWidth\x12\x0e\n\x06height\x18\x01 \x01(\x02\x12\r\n\x05width\x18\x02 \x01(\x02\x32\xa3\x01\n\x0e\x43urtainService\x12)\n\x04open\x12\x0e.StringRequest\x1a\x0f.StringResponse\"\x00\x12*\n\x05\x63lose\x12\x0e.StringRequest\x1a\x0f.StringResponse\"\x00\x12:\n\x14\x61\x64justHeightAndWidth\x12\x0f.HeightAndWidth\x1a\x0f.StringResponse\"\x00\x62\x06proto3'
)




_STRINGREQUEST = _descriptor.Descriptor(
  name='StringRequest',
  full_name='StringRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='stringRequestValue', full_name='StringRequest.stringRequestValue', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=17,
  serialized_end=60,
)


_BOOLEANREQUEST = _descriptor.Descriptor(
  name='BooleanRequest',
  full_name='BooleanRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='booleanRequestValue', full_name='BooleanRequest.booleanRequestValue', index=0,
      number=1, type=8, cpp_type=7, label=1,
      has_default_value=False, default_value=False,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=62,
  serialized_end=107,
)


_STRINGRESPONSE = _descriptor.Descriptor(
  name='StringResponse',
  full_name='StringResponse',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='stringResponseValue', full_name='StringResponse.stringResponseValue', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=109,
  serialized_end=154,
)


_HEIGHTANDWIDTH = _descriptor.Descriptor(
  name='HeightAndWidth',
  full_name='HeightAndWidth',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='height', full_name='HeightAndWidth.height', index=0,
      number=1, type=2, cpp_type=6, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='width', full_name='HeightAndWidth.width', index=1,
      number=2, type=2, cpp_type=6, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=156,
  serialized_end=203,
)

DESCRIPTOR.message_types_by_name['StringRequest'] = _STRINGREQUEST
DESCRIPTOR.message_types_by_name['BooleanRequest'] = _BOOLEANREQUEST
DESCRIPTOR.message_types_by_name['StringResponse'] = _STRINGRESPONSE
DESCRIPTOR.message_types_by_name['HeightAndWidth'] = _HEIGHTANDWIDTH
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

StringRequest = _reflection.GeneratedProtocolMessageType('StringRequest', (_message.Message,), {
  'DESCRIPTOR' : _STRINGREQUEST,
  '__module__' : 'curtain_pb2'
  # @@protoc_insertion_point(class_scope:StringRequest)
  })
_sym_db.RegisterMessage(StringRequest)

BooleanRequest = _reflection.GeneratedProtocolMessageType('BooleanRequest', (_message.Message,), {
  'DESCRIPTOR' : _BOOLEANREQUEST,
  '__module__' : 'curtain_pb2'
  # @@protoc_insertion_point(class_scope:BooleanRequest)
  })
_sym_db.RegisterMessage(BooleanRequest)

StringResponse = _reflection.GeneratedProtocolMessageType('StringResponse', (_message.Message,), {
  'DESCRIPTOR' : _STRINGRESPONSE,
  '__module__' : 'curtain_pb2'
  # @@protoc_insertion_point(class_scope:StringResponse)
  })
_sym_db.RegisterMessage(StringResponse)

HeightAndWidth = _reflection.GeneratedProtocolMessageType('HeightAndWidth', (_message.Message,), {
  'DESCRIPTOR' : _HEIGHTANDWIDTH,
  '__module__' : 'curtain_pb2'
  # @@protoc_insertion_point(class_scope:HeightAndWidth)
  })
_sym_db.RegisterMessage(HeightAndWidth)



_CURTAINSERVICE = _descriptor.ServiceDescriptor(
  name='CurtainService',
  full_name='CurtainService',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  serialized_start=206,
  serialized_end=369,
  methods=[
  _descriptor.MethodDescriptor(
    name='open',
    full_name='CurtainService.open',
    index=0,
    containing_service=None,
    input_type=_STRINGREQUEST,
    output_type=_STRINGRESPONSE,
    serialized_options=None,
  ),
  _descriptor.MethodDescriptor(
    name='close',
    full_name='CurtainService.close',
    index=1,
    containing_service=None,
    input_type=_STRINGREQUEST,
    output_type=_STRINGRESPONSE,
    serialized_options=None,
  ),
  _descriptor.MethodDescriptor(
    name='adjustHeightAndWidth',
    full_name='CurtainService.adjustHeightAndWidth',
    index=2,
    containing_service=None,
    input_type=_HEIGHTANDWIDTH,
    output_type=_STRINGRESPONSE,
    serialized_options=None,
  ),
])
_sym_db.RegisterServiceDescriptor(_CURTAINSERVICE)

DESCRIPTOR.services_by_name['CurtainService'] = _CURTAINSERVICE

# @@protoc_insertion_point(module_scope)