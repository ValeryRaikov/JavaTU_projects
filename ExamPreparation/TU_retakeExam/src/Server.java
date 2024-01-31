import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Server {
    private final Object emailsLock;
    private ServerSocket server;

    public Server() {
        emailsLock = new Object();
    }

//    Main server method
    public void start() {
        try {
            System.out.println("Server listening...");
            server = new ServerSocket(8080);

            while (true) {
                Socket client  = server.accept();

                Thread clientThread = new Thread(() -> {
                    System.out.println("Accepted client.");
                    Scanner in = null;
                    PrintStream out = null;

                    try {
                        in = new Scanner(client.getInputStream());
                        out = new PrintStream(client.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (in != null)
                            in.close();
                        if (out != null)
                            out.close();
                    }
                });

                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    Method for adding users in the users hashmap collection
    public void addUser(String email, String pass) {
        synchronized (emailsLock) {
            EmailDatabase.usersMap.putIfAbsent(email, pass);
        }
    }

//    Method for checking users credentials
    public void checkCredentials(String email, String pass) throws InvalidUserException {
        if (!EmailDatabase.usersMap.containsKey(email) || !EmailDatabase.usersMap.get(email).equals(pass)) {
            throw new InvalidUserException("Invalid email or password credentials!");
        }
    }

//    Method for check for spam emails
    public boolean isSpam(Email email) {
        String[] wordsInEmail = email.getContent().split("\\s+");
        double averageProbability = 0;

        for (String word: wordsInEmail) {
            averageProbability += EmailDatabase.words.getOrDefault(word.toLowerCase(), 0.0);
        }

        return averageProbability / wordsInEmail.length >= 0.8;
    }

//    Method for sending email to recipient
    public void sendEmail(Email email, String recipient) throws InvalidUserException {
        if (!EmailDatabase.usersMap.containsKey(recipient)) {
            throw new InvalidUserException("No such recipient found!");
        }

        File inboxFile = new File(recipient + "/inbox");
        File spamFile = new File(recipient + "/spam");

        if (!inboxFile.getParentFile().exists())
            inboxFile.getParentFile().mkdirs();

        if (isSpam(email)) {
            synchronized (spamFile) {
                email.appendToFile(spamFile.getPath());
            }
        } else {
            synchronized (inboxFile) {
                email.appendToFile(inboxFile.getPath());
            }
        }
    }

//    Method for filtering emails
    public List<Email> filterEmails(String path, String sender, String subject) {
        List<Email> allEmails = Email.loadFromFile(path);

        return Objects.requireNonNull(allEmails).stream()
                .filter(email -> sender.isBlank() || email.getSender().equals(sender))
                .filter(email -> subject.isBlank() || email.getSubject().equals(subject))
                .toList();
    }
}
