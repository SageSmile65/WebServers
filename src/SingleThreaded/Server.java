package SingleThreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(30000);

        while(true){
            System.out.println("Waiting for connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Connection established");
            PrintWriter toClient = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println(fromClient.readLine());
            toClient.println("Hello from the server");

            fromClient.close();
            toClient.close();
            socket.close();
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}