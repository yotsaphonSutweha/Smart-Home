import grpc
import curtain_pb2
import curtain_pb2_grpc
from concurrent import futures
import logging

class CurtainService(curtain_pb2_grpc.CurtainServiceServicer):
    def open(self, request, context):
        response = curtain_pb2.StringResponse()
        response.stringResponseValue = request.stringRequestValue
        return response

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))

    curtain_pb2_grpc.add_CurtainServiceServicer_to_server(CurtainService(), server)

    print('Starting server. Listening on PORT 50051')
    server.add_insecure_port('[::]:50051')
    server.start()
    server.wait_for_termination()

if __name__ == '__main__':
    logging.basicConfig()
    try:
        serve()
    except KeyboardInterrupt:
        print("Keyboard interrupted")
