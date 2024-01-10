import java.io.*;
import java.util.Scanner;

public class Files {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter filename: ");
        String filename = sc.nextLine();

        File file = createFile(filename);

        System.out.println("Enter text you want to write to a file:");
        String text = sc.nextLine();

        writeToFile(file, text);

        System.out.println("Reading from the file you wrote text:");
        readFromFile(file);
    }

    public static File createFile(String filename) {
        File file = new File(filename);

        try {
            if (file.createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println("File already created. Skipping...");
            }
        } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        return file;
    }

    public static void writeToFile(File file, String text) {
        if (!file.exists() || !file.canExecute()) {
            System.err.println("Error with file!");
        }

        try(FileWriter writer = new FileWriter(file)) {
            writer.write(text);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void readFromFile(File file) {
        if (!file.exists() || !file.canExecute()) {
            System.err.println("Error with file!");
        }

        try(FileInputStream reader = new FileInputStream(file)) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
