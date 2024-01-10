package RegexExam;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();

        try (Socket socket = new Socket("localhost", 8080)){
            Scanner serverInput = new Scanner(socket.getInputStream());
            PrintStream clientOutput = new PrintStream(socket.getOutputStream());

            Scanner userInput = new Scanner(System.in);

            while (true) {
                System.out.println("Enter a message to send to the server (type 'exit' to quit):");
                String message = userInput.nextLine();

                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }

                clientOutput.println(message);

                String response = serverInput.nextLine();
                System.out.println("Server response: " + response);
            }

            socket.close();
            serverInput.close();
            clientOutput.close();
            userInput.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
