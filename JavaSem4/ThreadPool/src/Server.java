import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private List<PrintStream> clients;
    private final Object clientsLock;

    public List<PrintStream> getClients() {
        return clients;
    }

    public void setClients(List<PrintStream> clients) {
        this.clients = clients;
    }

    public Object getClientsLock() {
        return clientsLock;
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(ExecutorService threadPool) {
        this.threadPool = threadPool;
    }

    private ExecutorService threadPool;

    private class ServerRunnable implements Runnable {
        private final Socket client;

        public ServerRunnable(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (Scanner in = new Scanner(client.getInputStream());
                 PrintStream out = new PrintStream(client.getOutputStream())) {
                    synchronized (clientsLock) {
                        clients.add(out);
                }

                while (true) {
                    String line = in.nextLine();
                    if (line.contains("quit")) {
                        synchronized (clientsLock) {
                            clients.remove(out);
                            return;
                        }
                    }
                    synchronized (clientsLock) {
                        for (PrintStream c : clients)
                            c.println(line);
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public Server() {
        clients = new ArrayList<>();
        clientsLock = new Object();
        threadPool = Executors.newFixedThreadPool(3);
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);

            while (true) {
                Socket client = serverSocket.accept();
                threadPool.execute(new ServerRunnable(client));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().start();
    }
}
