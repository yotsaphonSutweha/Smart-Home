import grpc 

import curtain_pb2
import curtain_pb2_grpc
import socket
from time import sleep
import sys
import logging
from zeroconf import ServiceBrowser, ServiceStateChange, Zeroconf, ServiceInfo
import concurrent
from concurrent import futures
import socket

CLIENT_PORT = 8081

def zeroconf_info():

    service_info = {
        "PORT": 0,
        "Name" : "",
        "Address" : "",
        "Server" : ""
    }

    def on_service_state_change(zeroconf, service_type, name, state_change):
        if state_change is ServiceStateChange.Added:
            info = zeroconf.get_service_info(service_type, name)
            if info and info.server == "localhost._curtainserver._tcp.local.":
                print("Address: %s:%d" % (socket.inet_ntoa(info.address), info.port))
                print("Weight: %d, priority: %d" % (info.weight, info.priority))
                print("Server: %s" % (info.server,))

                service_info["PORT"] = info.port
                service_info["Name"] = name
                service_info["Address"] = info.address
                service_info["Server"] = info.server

                if info.properties:
                    print("Properties are:")
                    for key, value in info.properties.items():
                        print("%s: %s" % (key, value))
                else:
                    print("No properties")
            print('\n')

    zeroconf = Zeroconf()
    browser = ServiceBrowser(zeroconf, "_curtainserver._tcp.local.", handlers=[on_service_state_change])
    sleep(1)
    return service_info

def dns_service_registration():
    print("Registering python client....")
    info = ServiceInfo("_curtain._tcp.local.", 
        "localhost._curtain._tcp.local.",
        socket.inet_aton("127.0.0.1"), CLIENT_PORT, 0, 0,)
    zeroconf = Zeroconf()
    zeroconf.register_service(info)

if __name__ == "__main__":
    logging.basicConfig(level=logging.DEBUG)
    if len(sys.argv) > 1:
        assert sys.argv[1:] == ['--debug']
        logging.getLogger('zeroconf').setLevel(logging.DEBUG)

    print("\nBrowsing services, press Ctrl-C to exit...\n")
    discovered_service_info = zeroconf_info()
    # open grpc channel 
    channel = grpc.insecure_channel('localhost:{0}'.format(discovered_service_info ["PORT"]))

    # create the stub with inserted channel
    stub = curtain_pb2_grpc.CurtainServiceStub(channel)

    # Registering client service using DNS
    dns_service_registration()

    # Open socket connection to communicate with Java client
    s = socket.socket()
    s.bind(('', CLIENT_PORT))
    print("Socket connection has opened...")
    s.listen(5)
   
    try:
        while True: 
            clientsocket, address = s.accept()
            print("Connection from {0} has been established!".format(address))
            length_of_message = int.from_bytes(clientsocket.recv(2), byteorder="big")
            message = clientsocket.recv(length_of_message).decode("UTF-8")
            message = message.strip()
            if message == "Open":
                # create the request 
                request_open = curtain_pb2.StringRequest(stringRequestValue=message)
                # make the call
                response_open = stub.open(request_open)
                print(response_open.stringResponseValue)
                message_to_send = response_open.stringResponseValue.encode("UTF-8")
                clientsocket.send(len(message_to_send).to_bytes(2, byteorder="big"))
                clientsocket.send(message_to_send)

            elif message == "Close":
                # create the request 
                request_close = curtain_pb2.StringRequest(stringRequestValue=message)
                response_close = stub.close(request_close)
                print(response_close.stringResponseValue)
                message_to_send = response_close.stringResponseValue.encode("UTF-8")
                clientsocket.send(len(message_to_send).to_bytes(2, byteorder="big"))
                clientsocket.send(message_to_send)
            else:
                arr = []
                arr = message.split(",")
                if float(arr[0]) and float(arr[1]):
                    width_height_adjustment = curtain_pb2.HeightAndWidth(width=float(arr[0]), height=float(arr[1]))
                width_height_response = stub.adjustHeightAndWidth(width_height_adjustment)
                print(width_height_response.stringResponseValue)

    except KeyboardInterrupt:
        s.close()
        print("Socket connection terminated")

