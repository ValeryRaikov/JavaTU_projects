import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    private static final String REGEXES_FILENAME = "regex_db.txt";

    private final Object regexesLock;

    public Server() {
        //initRegexes();
        regexesLock = new Object();
    }

    public void start()
    {
        try
        {
            System.out.println("Server listening.");
            ServerSocket server = new ServerSocket(8080);

            while (true)
            {
                Socket client = server.accept();

                Thread clientThread = new Thread(() ->
                {
                    System.out.println("Accepted client.");
                    Scanner sc = null;
                    PrintStream out = null;

                    try
                    {
                        sc = new Scanner(client.getInputStream());
                        out = new PrintStream(client.getOutputStream());
                        menu(sc, out);
                    }
                    catch (IOException e)
                    {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                    }
                    finally
                    {
                        if (sc != null)
                            sc.close();
                        if (out != null)
                            out.close();
                    }
                });

                clientThread.start();
            }
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /*unchecked*/
    public List<Regex> loadRegexes() throws IOException {
        File file = new File(REGEXES_FILENAME);

        if (!file.exists()) {
            boolean created = file.createNewFile();

            if (!created) {
                throw new IOException("Error while creating file (" + REGEXES_FILENAME + ")");
            }
            return new ArrayList<>();
        } else {
            List<Regex> regexes = new ArrayList<>();

            try(BufferedReader reader = new BufferedReader(new FileReader(REGEXES_FILENAME))){
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    String[] params = currentLine.split(", ");

                    if (params.length == 4) {
                        int id = Integer.parseInt(params[0]);
                        String pattern = params[1];
                        String description = params[2];
                        int rating = Integer.parseInt(params[3]);

                        Regex currRegex = new Regex(pattern, description);
                        currRegex.setId(id);
                        currRegex.setRating(rating);

                        regexes.add(currRegex);
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            return regexes;
        }
    }

    private void saveRegex(String pattern, String description) throws IOException {
        Regex regex = new Regex(pattern, description);
        synchronized (regexesLock)
        {
            List<Regex> regexes = loadRegexes();
            boolean found = false;
            for (Regex currRegex : regexes) {
                if(currRegex.getPattern().equals(regex.getPattern())) {
                    found = true;
                }
            }
            if(!found) {
                regexes.add(regex);
            }
            saveRegexes(regexes);
        }
    }

    public void saveRegexes(List<Regex> regexes)
    {
        synchronized (regexesLock)
        {
            try(BufferedWriter wr = new BufferedWriter(new FileWriter(REGEXES_FILENAME))) {
                for (Regex regex : regexes) {
                    wr.write(regex.toString());
                    wr.newLine();
                    wr.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void menu(Scanner sc, PrintStream out) throws IOException {
        while (true) {
            out.println("Commands List - Just enter number: \n - Create Regex: 1\n - Find Regex: 2\n" +
                    " - Any other key will be considered as end of program\n Enter command:");

            String command = sc.nextLine();

            if (command.equals("1")) {
                createRegexHandler(sc, out);
            } else if (command.equals("2")){
                findRegexHandler(sc, out);
            }
            else {
                out.println("The program has stopped working");
                return;
            }
        }
    }

    private void createRegexHandler(Scanner sc, PrintStream out) throws IOException {
        out.println("Enter pattern:");
        String pattern = sc.nextLine();

        out.println("Enter description:");
        String description = sc.nextLine();

        //saveRegex(pattern, description);
        out.println("Enter message separated with space:");
        String[] message = sc.nextLine().trim().split(" ");
        Regex tempRegex = new Regex(pattern, description);
        List<Boolean> result = RegexTester.test(tempRegex, message);
        out.println("Result: " + result);

        out.println("1 - Save, Any other key - Do not save");
        String choice = sc.nextLine();
        if(choice.equals("1")) {
            saveRegex(pattern, description);
            //out.println("Regex saved!");
        }
    }

    private void findRegexHandler(Scanner sc, PrintStream out) throws IOException {
        out.println("Enter keyword:");
        String keyword = sc.nextLine();

        List<Regex> regexes = loadRegexes();
        out.println(regexes.size());
        if(regexes.isEmpty()) {
            out.println("There are no regexes added yet!");
            return;
        }
        List<Regex> foundRegexes = new ArrayList<>();
        for(Regex regex : regexes) {
            if(regex.getDescription().contains(keyword)) {
                foundRegexes.add(regex);
            }
        }
        out.println(foundRegexes.size());
        if(foundRegexes.isEmpty()) {
            out.println("There are no matches!");
            return;
        }



        foundRegexes.sort(new Comparator<Regex>() {
            @Override
            public int compare(Regex o1, Regex o2) {
                return o2.getRating() - o1.getRating();
            }
        });

        for(Regex regex : foundRegexes) {
            out.println("ID: " + regex.getId() + " Pattern: " + regex.getPattern() + " Description: " + regex.getDescription() + " Rating: " + regex.getRating());
        }

        out.println("Enter id:");
        int chosenId = Integer.parseInt(sc.nextLine());
        Regex chosenRegex = foundRegexes.stream().filter(r -> r.getId() == chosenId).findFirst().orElse(null);
        if(chosenRegex == null) {
            out.println("This regex does not exist");
            return;
        } else {
            out.println("Pattern: " + chosenRegex.getPattern());
        }

        out.println("Enter message separated with space:");
        String[] message = sc.nextLine().trim().split(" ");
        List<Boolean> result = RegexTester.test(chosenRegex, message);
        out.println("Result: " + result);

        out.println("Add rating: (plus), (minus): ");
        String ratingCommand = sc.nextLine();
        if(ratingCommand.equalsIgnoreCase("plus")){
            chosenRegex.setRating(chosenRegex.getRating()+1);
        } else if (ratingCommand.equalsIgnoreCase("minus")) {
            chosenRegex.setRating(chosenRegex.getRating()-1);
        }

        List<Regex> finalRegexes = new ArrayList<>();
        for(Regex regex : regexes) {
            if(regex.getId() == chosenRegex.getId()) {
                finalRegexes.add(chosenRegex);
            } else {
                finalRegexes.add(regex);
            }
        }

        saveRegexes(finalRegexes);
    }
}