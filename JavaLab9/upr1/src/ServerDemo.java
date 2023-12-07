import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerDemo {

    public static void main(String[] args) throws IOException {

        int number;
        ServerSocket server = new ServerSocket(1211);
        System.out.println("Server started...");
        Socket socket = server.accept();
        System.out.println("New client connection...");
        Scanner scan = new Scanner(socket.getInputStream());
        number = scan.nextInt();
        PrintStream printout = new PrintStream(socket.getOutputStream());
        if ((number % 2) == 0) {
            printout.println("Your number is even.");
        } else {
            printout.println("Your number is odd.");
        }

        server.close();
        System.out.println("Server stopped.");
        scan.close();

    }

}
