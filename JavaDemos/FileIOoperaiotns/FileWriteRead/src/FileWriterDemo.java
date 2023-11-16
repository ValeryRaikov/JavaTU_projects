import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterDemo {
    public static void main(String[] args) {
        System.out.println("Java program to write into a file:");

        String[] names = {
                "Valery", "Ivan", "Peter", "Margo"
        };

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("test_output.txt"));
            writer.write("First line!");
            writer.write("\nAnother line.\n");

            // Write from user dynamic input using scanner:
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your text here: ");
            String userInput = sc.nextLine();
            writer.write(userInput);

            // Write from existing collection:
            writer.write("\nNames array:");
            for (String name: names) {
                writer.write("\n" + name);
            }

            // Close the writer class:
            writer.close();
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println("Unexpected exception: " + e.getMessage());
        }
        finally {
            System.out.println("That's it.");
        }
    }
}
