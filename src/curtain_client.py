import grpc 

import curtain_pb2
import curtain_pb2_grpc

# open grpc channel 
channel = grpc.insecure_channel('localhost:8080')

# create the request 
request_open = curtain_pb2.StringRequest(stringRequestValue="Open")

# create the stub with inserted channel
stub = curtain_pb2_grpc.CurtainServiceStub(channel)

# make the call
response_open = stub.open(request_open)

# print out the value 
print(response_open.stringResponseValue)

request_close = curtain_pb2.StringRequest(stringRequestValue="Close")

response_close = stub.close(request_close)

print(response_close.stringResponseValue)

width_height_adjustment = curtain_pb2.HeightAndWidth(width=1, height=2)

width_height_response = stub.adjustHeightAndWidth(width_height_adjustment)

print(width_height_response.stringResponseValue)

