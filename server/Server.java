import java.io.*;
import java.net.*;
import model.*;

/**
 * Server
 */
public class Server {

    public static void main(String[] args) throws IOException {

        // Integer port = Integer.parseInt(args[0]);
        // start server
        Server server = new Server();
        server.start(60000);
    }

    private void start(int port) throws IOException {

        // start the server and load the CSV's data
        ServerSocket serverSocket = new ServerSocket(port);
        Model moviesModel = new Model();

        while (true) {
            // accept a connection
            Socket clientSocket = serverSocket.accept();

            // read input from client
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            byte[] buffer = new byte[50];
            input.read(buffer);
            String query = new String(buffer);

            // query the CSV file
            String queryRes = moviesModel.queryMovie(query);

            // send querys response to client
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
            output.writeUTF(queryRes);

            // close the connection
            input.close();
            output.close();
            clientSocket.close();
        }
    }
}