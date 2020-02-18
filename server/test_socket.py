import socket

clientsocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
clientsocket.connect(('localhost', 8000)) 

message = "1|TDuchess"

clientsocket.send(message.encode('utf-8'))

mybytes2 = clientsocket.recv(1024)

name = mybytes2.decode('utf-8')

print(name)

clientsocket.close()
