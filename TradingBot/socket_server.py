# -*- coding:utf8 -*-

import socketserver
import threading
import predictor
import json

class RequestHandler(socketserver.StreamRequestHandler):
    def handle(self):

        # get socket request
        socket = self.request

        # show client
        print('Connect with : ' + self.client_address[0])

        timeInterval = socket.recv(1024)
        timeInterval = bytes.decode(timeInterval)
        print('Recieved Time Interval : ', timeInterval)

        predictor_instance = predictor.Connect(timeInterval)

        result = predictor_instance.predict()
        print('result: ', result)
        socket.sendall(str(result.item()).encode())
        socket.close()

        
if __name__ == '__main__':
    HOST = '127.0.0.1'
    PORT = 5005

    server = socketserver.TCPServer((HOST, PORT), RequestHandler)

    print('Socket is now listening ...')
    server_thread = threading.Thread(target=server.serve_forever())
    server_thread.setDaemon(True)
    server_thread.start()
