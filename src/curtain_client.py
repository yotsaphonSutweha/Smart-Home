import grpc 

import curtain_pb2
import curtain_pb2_grpc

# open grpc channel 
channel = grpc.insecure_channel('localhost:50051')

# create the request 
request = curtain_pb2.StringRequest(stringRequestValue="arggggg")

# create the stub with inserted channel
stub = curtain_pb2_grpc.CurtainServiceStub(channel)

# make the call
response = stub.open(request)

# print out the value 
print(response.stringResponseValue)