import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Server {

    public static class User implements Serializable {
        private String username;
        private String password;

        public User(String username, String password) throws WrongCredentialsException {
            setUsername(username);
            setPassword(password);
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) throws WrongCredentialsException {
            if (!username.matches("^\\w{4,}$")) {
                throw new WrongCredentialsException("Error: Invalid username format!");
            }

            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) throws WrongCredentialsException {
            if (!password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()-_+=])[A-Za-z\\d!@#$%^&*()-_+=]{8,}$")) {
                throw new WrongCredentialsException("Error: Invalid password format!");
            }

            this.password = password;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(username, user.username) &&
                    Objects.equals(password, user.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(username, password);
        }
    }

    public static class WrongCredentialsException extends Exception {
        public WrongCredentialsException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        int port = 1234;
        ServerSocket serverSocket = null;
        Socket connection = null;
        Scanner socketIn = null;
        PrintWriter socketOut = null;

        try {
            serverSocket = new ServerSocket(port);

            while (true) {
                System.out.println("Server awaits connection...");
                connection = serverSocket.accept();

                System.out.println("Client connected: " + connection.getInetAddress().getHostName());
                socketOut = new PrintWriter(connection.getOutputStream(), true);
                socketOut.println("Hello there! Please enter your username and password to continue...");

                boolean isValidUser = false;
                User user = null;
                while (!isValidUser) {
                    socketIn = new Scanner(new BufferedReader(new InputStreamReader(connection.getInputStream())));
                    String username = socketIn.nextLine();
                    String password = socketIn.nextLine();

                    try {
                        user = new User(username, password);
                        isValidUser = true;

                        if (!searchUserInFile(user)) {
                            socketOut.println("No such user found! Do you want to register:");
                            String response = socketIn.nextLine();

                            if (response.equalsIgnoreCase("yes")) {
                                socketOut.println("Successfully registered as " + username + "! Chat begins:");
                                writeUserToFile(user);
                            } else if (response.equalsIgnoreCase("no")) {
                                socketOut.println("Goodbye!");
                                System.exit(1);
                            } else {
                                socketOut.println("Invalid command!");
                            }
                        }
                    } catch (WrongCredentialsException e) {
                        socketOut.println(e.getMessage() + " Retry? (yes/no):");
                        String retryResponse = socketIn.nextLine();
                        if (!retryResponse.equalsIgnoreCase("yes")) {
                            System.exit(1);
                        }
                    }
                }

                Scanner serverScan = new Scanner(System.in);
                String userMessage;

                do {
                    socketOut.flush();
                    userMessage = socketIn.nextLine();

                    if (userMessage.equalsIgnoreCase("exit")) {
                        break;
                    }

                    System.out.println(user.getUsername() + ": " + userMessage);
                    System.out.print("Me: ");
                    String response = serverScan.nextLine();
                    socketOut.println(response);

                } while (true);

                System.out.println("Closing the connection with: " + connection.getInetAddress().getHostName());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (socketIn != null)
                    socketIn.close();
                if (socketOut != null)
                    socketOut.close();
                if (connection != null)
                    connection.close();
            } catch (IOException e) {
                System.err.println("Socket failed to close!");
            }
        }
    }

    public static void writeUserToFile(User user) {
        File file = new File("users.txt");

        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file, true))) {
            if (!file.exists()) {
                file.createNewFile();
            }

            writer.writeObject(user);
            System.out.println("User written to file successfully.");

        } catch (IOException e) {
            System.err.println("Error writing user to file: " + e.getMessage());
        }
    }

    public static boolean searchUserInFile(User user) {
        File file = new File("users.txt");

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
            if (!file.exists()) {
                return false;
            }

            try {
                while (true) {
                    User readUser = (User) reader.readObject();

                    if (readUser.equals(user)) {
                        System.out.println("User found in the system!");
                        return true;
                    }
                }
            } catch (EOFException e) {
                System.err.println("End of file reached: " + e.getMessage());
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        return false;
    }
}
