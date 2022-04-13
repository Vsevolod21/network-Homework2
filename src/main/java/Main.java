import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(("Сервер стартовал"));
        int port = 8075;

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter
                    (clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader
                    (new InputStreamReader(clientSocket.getInputStream()));
            System.out.printf("Новое соединение принято. Порт: %d%n",
                    clientSocket.getPort());

            out.println("Write your name");

            String username = in.readLine();
            System.out.println(username);

            out.println("Are you child? (yes/no)");

            String clientMessage2 = in.readLine();
            System.out.println(clientMessage2);

            out.println(String.format
                    ("Welcome to the kids area, %s! Let's play!", username));

            String clientMessage3 = in.readLine();
            System.out.println(clientMessage3);
            serverSocket.close();
            break;
        }
    }
}
