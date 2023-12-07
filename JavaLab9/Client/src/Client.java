import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket connection = null;
        Scanner socketIn = null;
        PrintWriter socketOut = null;
        Scanner keyboardIn = new Scanner(System.in);
        int port = 1234;
        String host = "127.0.0.1";

        try {
            try {
                connection = new Socket(host, port);
            } catch (ConnectException e) {
                System.err.println("Cannot connect to the server!");
                return;
            }
            System.out.println("Connection successful!");

            socketIn = new Scanner(new BufferedReader(new InputStreamReader(connection.getInputStream())));
            socketOut = new PrintWriter(connection.getOutputStream(), true);

            String command = null;
            do {
                System.out.print("You: ");
                command = keyboardIn.nextLine();
                socketOut.println(command);

                if (command.equalsIgnoreCase("exit")) {
                    break;
                }

                String answer = socketIn.nextLine();
                System.out.println("Server: " + answer);

            } while (true);
            System.out.println("Closing the connection.");

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
                keyboardIn.close();
            } catch (IOException e) {
                System.err.println("Socket failed to close!");
            }
        }
    }
}
