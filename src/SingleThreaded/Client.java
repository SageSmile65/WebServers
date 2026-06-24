package SingleThreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    int port = 8080;
    public void run() throws IOException {
        InetAddress address = InetAddress.getLocalHost();
        Socket socket = new Socket(address,port );

        PrintWriter toServer = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        toServer.println("Hello from client");
        String response = fromServer.readLine();
        System.out.println("Response from server: " + response);

        toServer.close();
        fromServer.close();
        socket.close();
    }

    public static void main(String[] args) {
        try {
            new Client().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
