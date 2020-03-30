import grpc
import curtain_pb2
import curtain_pb2_grpc
from concurrent import futures
import logging
from zeroconf import ServiceBrowser, Zeroconf, ServiceInfo
from time import sleep
import socket
import ipaddress

class CurtainService(curtain_pb2_grpc.CurtainServiceServicer):
    def open(self, request, context):
        if request.stringRequestValue == "Open":
            response = curtain_pb2.StringResponse()
            response.stringResponseValue = "Curtain: Open"
            print(response.stringResponseValue)
            return response
        else:
            response = curtain_pb2.StringResponse()
            response.stringResponseValue = "Incorrect command!"
            return response

    def close(self, request, context):
        if request.stringRequestValue == "Close":
            response = curtain_pb2.StringResponse()
            response.stringResponseValue = "Curtain: Close"
            print(response.stringResponseValue)
            return response
        else:
            response = curtain_pb2.StringResponse()
            response.stringResponseValue = "Incorrect command!"
            return response

    def adjustHeightAndWidth(self, request, context):
        width = request.width
        height = request.height
        print("Width {0}".format(width))
        print("Height {0}".format(height))
        response = curtain_pb2.StringResponse()
        response.stringResponseValue = str(width) + "," + str(height)
        return response

class ServiceRegistration:
    PORT = 8080
    def dns_service_registration(self):
        info = ServiceInfo("_curtainserver._tcp.local.", 
                        "localhost._curtainserver._tcp.local.",
                            socket.inet_aton("127.0.0.1"), self.PORT, 0, 0,)
        zeroconf = Zeroconf()
        print("Curtain server is at PORT 8080")
        zeroconf.register_service(info)
    
    def serve(self):
        # Registering service
        self.dns_service_registration()
        server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
        curtain_pb2_grpc.add_CurtainServiceServicer_to_server(CurtainService(), server)
        print("gRPC services are listening on PORT 8080")
        server.add_insecure_port("[::]:{0}".format(self.PORT))
        server.start()
        server.wait_for_termination()

if __name__ == "__main__":
    logging.basicConfig()
    try:
        services = ServiceRegistration()
        services.serve()
    except KeyboardInterrupt:
        print("Keyboard interrupted")
