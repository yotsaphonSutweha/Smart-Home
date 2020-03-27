import grpc 

import curtain_pb2
import curtain_pb2_grpc
import socket
from time import sleep
import sys
import logging
from zeroconf import ServiceBrowser, ServiceStateChange, Zeroconf
import concurrent
PORT = 0 


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
            if info:
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
            else:
                print("No info")
            print('\n')

    zeroconf = Zeroconf()
    browser = ServiceBrowser(zeroconf, "_http._tcp.local.", handlers=[on_service_state_change])
    sleep(1)
    return service_info

if __name__ == "__main__":
    logging.basicConfig(level=logging.DEBUG)
    if len(sys.argv) > 1:
        assert sys.argv[1:] == ['--debug']
        logging.getLogger('zeroconf').setLevel(logging.DEBUG)


    print("\nBrowsing services, press Ctrl-C to exit...\n")
    discovered_service_info = zeroconf_info()

    print("PORT {0}".format(discovered_service_info["PORT"]))
            
    # open grpc channel 
    channel = grpc.insecure_channel('localhost:{0}'.format(discovered_service_info ["PORT"]))

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


