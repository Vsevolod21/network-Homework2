import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";

        int port = 8075;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {

            String serverMessage1 = in.readLine();
            System.out.println(serverMessage1);

            out.println("Чувак");

            String serverMessage2 = in.readLine();
            System.out.println(serverMessage2);

            out.println("Yes");

            String serverMessage3 = in.readLine();
            System.out.println(serverMessage3);

            out.println("Thank you ever so much!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
