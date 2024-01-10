package RegexExam;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Server {

    private static final String FILENAME = "regex-file.txt";
    private final Object regexesLock;

    public Server() {
        regexesLock = new Object();
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server listening...");

            while (true) {
                Socket client = server.accept();

                Thread clientThread = new Thread(() -> {
                    System.out.println("Client accepted.");

                    try {
                        try (Scanner in = new Scanner(client.getInputStream());
                             PrintStream out = new PrintStream(client.getOutputStream())) {
                             menu(in, out);
                        }
                    } catch (IOException e) {

                        System.err.println("Error while processing client: " + e.getMessage());
                    }
                });

                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public File createFile(String filename) throws IOException {
        File file = new File(FILENAME);

        if (!file.exists()) {
            boolean isCreated = file.createNewFile();

            if (!isCreated) {
                throw new IOException("Error creating file! ");
            }
        }

        return file;
    }

    public static List<Regex> readRegexesFromFile() throws IOException {
        List<Regex> regexes = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            while (true) {
                Regex currRegex = (Regex) ois.readObject();

                if (currRegex == null)
                    break;

                regexes.add(currRegex);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

        return regexes;
    }

    public void checkWriteRegex(String pattern, String description) throws IOException {
        Regex regex = new Regex(pattern, description);

        synchronized (regexesLock) {
            List<Regex> regexes = readRegexesFromFile();

            boolean isFound = false;
            for(Regex currRegex: regexes) {
                if (regex.getPattern().equals(currRegex.getPattern())) {
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                regexes.add(regex);
                writeRegexesToFile(regexes);
            }
        }
    }

    public void writeRegexesToFile(List<Regex> regexes) throws IOException {
        synchronized (regexesLock) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
                for (Regex regex: regexes) {
                    oos.writeObject(regex);
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void menu(Scanner in, PrintStream out) throws IOException {
        while (true) {
            out.println("You are allowed the following actions:\n1-Create regex\n2-Search for regex\n" +
                    "Any other key will end the program!");

            int command = in.nextInt();

            if (command == 1) {
                createRegexMenu(in, out);
            } else if (command == 2) {
                searchRegexMenu(in, out);
            } else {
                out.println("Program quitting...");
                return;
            }
        }
    }

    public void createRegexMenu(Scanner in, PrintStream out) throws IOException {
        out.println("Enter regex pattern:");
        String pattern = in.nextLine();

        out.println("Enter regex description:");
        String description = in.nextLine();

       out.println("Enter test strings:");
       String[] testStrings = in.nextLine().split(" ");

       Regex clientRegex = new Regex(pattern, description);

       List<Boolean> result = RegexTester.test(clientRegex, testStrings);
       out.println("Result: " + result);

       out.println("Do you want to save regex to file?Y/N");
       String command = in.nextLine();

       if (command.equalsIgnoreCase("Y")) {
           checkWriteRegex(pattern, description);
           out.println("Save to file... Redirecting");
       } else {
           out.println("Regex not saved");
       }
    }

    public void searchRegexMenu(Scanner in, PrintStream out) throws IOException {
        out.println("Enter keyword to search for regex:");
        String keyword = in.nextLine();

        List<Regex> regexes = readRegexesFromFile();

        if (regexes.isEmpty()) {
            out.println("There are no regexes currently added!");
            return;
        }

        List<Regex> foundRegexes = new ArrayList<>();
        for (Regex regex: regexes) {
            if (regex.getDescription().contains(keyword))
                foundRegexes.add(regex);
        }

        out.println("Found regexes: " + foundRegexes);

        if (foundRegexes.isEmpty()) {
            out.println("No matches with the given keyword!");
            return;
        }

        foundRegexes.sort(new Comparator<Regex>() {
            @Override
            public int compare(Regex o1, Regex o2) {
                return o2.getRating() - o1.getRating();
            }
        });

        for (Regex regex: foundRegexes)
            out.println(regex.toString());

        out.println("Enter regex id:");
        int id = in.nextInt();

        Regex chosenRegex = null;
        for (Regex regex: foundRegexes) {
            if (regex.getId() == id) {
                chosenRegex = regex;
                break;
            }
        }

        if (chosenRegex == null) {
            out.println("No such regex found!");
            return;
        }

        out.println("Found regex: " + chosenRegex);

        out.println("Enter test strings:");
        String[] testStrings = in.nextLine().split(" ");
        List<Boolean> result = RegexTester.test(chosenRegex, testStrings);
        out.println("Result: " + result);

        out.println("Add rating?+/-");
        String command = in.nextLine();

        if (command.equals("+")) {
            chosenRegex.setRating(chosenRegex.getRating() + 1);
        } else if (command.equals("-")) {
            chosenRegex.setRating(chosenRegex.getRating() - 1);
        } else {
            out.println("Invalid command... Skipping");
            return;
        }

        List<Regex> finalRegexes = new ArrayList<>();
        for (Regex regex: regexes) {
            if (regex.getId() == chosenRegex.getId()) {
                finalRegexes.add(chosenRegex);
            } else {
                finalRegexes.add(regex);
            }
        }

        writeRegexesToFile(finalRegexes);
    }
}
