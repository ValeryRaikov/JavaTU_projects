import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        int port = 1234;
        String host = "127.0.0.1";

        try (Socket connection = new Socket(host, port);
             PrintWriter socketOut = new PrintWriter(connection.getOutputStream(), true);
             Scanner socketIn = new Scanner(new BufferedReader(new InputStreamReader(connection.getInputStream())));
             Scanner userInput = new Scanner(System.in)) {

            String welcomeMessage = socketIn.nextLine();
            System.out.println("Server: " + welcomeMessage);

            System.out.print("Enter username: ");
            String username = userInput.nextLine();
            System.out.print("Enter password: ");
            String password = userInput.nextLine();

            socketOut.println(username);
            socketOut.println(password);

            String registrationResponse = socketIn.nextLine();
            System.out.println("Server: " + registrationResponse);

            String command;
            do {
                System.out.print("You: ");
                command = userInput.nextLine();
                socketOut.println(command);

                String response = socketIn.nextLine();
                System.out.println("Server: " + response);

            } while (!command.equalsIgnoreCase("exit"));

        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}
