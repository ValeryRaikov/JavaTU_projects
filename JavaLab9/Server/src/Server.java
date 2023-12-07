import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        int port = 1234;
        ServerSocket serverSocket = null;
        Socket connection = null;
        Scanner socketIn = null;
        PrintWriter socketOut = null;
        Scanner keyboardIn = new Scanner(System.in);

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Welcome to the simple chat program between a server and a client: ");

            connection = serverSocket.accept();
            System.out.println("Client connected to the server: " + connection.getInetAddress().getHostName());

            socketOut = new PrintWriter(connection.getOutputStream(), true);
            socketIn = new Scanner(new BufferedReader(new InputStreamReader(connection.getInputStream())));

            PrintWriter fileWriter = new PrintWriter(new FileWriter("chat_log.txt", true), true);

            String command = null;
            do {
                socketOut.flush();
                String answer = socketIn.nextLine();
                System.out.println("Client: " + answer);

                fileWriter.println("Client: " + answer);

                if (answer.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.print("You: ");
                command = keyboardIn.nextLine();
                socketOut.println(command);

                fileWriter.println("Server: " + command);
            } while (true);

            System.out.println("Connection with client interrupted: " + connection.getInetAddress().getHostName());

        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (socketIn != null)
                    socketIn.close();
                if (socketOut != null)
                    socketOut.close();
                if (connection != null)
                    connection.close();
                serverSocket.close();
                keyboardIn.close();
            } catch (IOException e) {
                System.err.println("Socket failed to close!");
            }
        }
    }
}
