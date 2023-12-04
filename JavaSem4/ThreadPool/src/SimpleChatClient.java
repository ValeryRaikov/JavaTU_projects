import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SimpleChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             Scanner in = new Scanner(socket.getInputStream());
             PrintStream out = new PrintStream(socket.getOutputStream())) {

            Thread reader = new Thread(() -> {
                while (true) {
                    if (in.hasNextLine()) {
                        String line = in.nextLine();
                        System.out.println("Received: " + line);
                    }
                }
            });
            reader.start();

            Scanner console = new Scanner(System.in);
            while (true) {
                String message = console.nextLine();
                out.println(message);
                if (message.equals("quit")) {
                    reader.interrupt();
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
