import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class IOStream {
    public static void main(String[] args) {
        File file = new File("sample.txt");

        if (file.exists()) {
            System.out.println("File already exists. You can continue...");
        }
        else {
            try {
                file.createNewFile();

                System.out.println("File name: " + file.getName());
                System.out.println("File path: " + file.getAbsolutePath());
                System.out.println("Is executable: " + file.canExecute());
            }
            catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your text here: ");
        String userInput = sc.nextLine();
        System.out.print("Enter your int numbers here: ");
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        try (FileOutputStream writer = new FileOutputStream(file)) {
            writer.write("Text:\n".getBytes());
            writer.write((userInput + "\n").getBytes());

            writer.write("Int numbers:\n".getBytes());
            for (int i = 0; i < numbers.length; i++) {
                writer.write((numbers[i] + "\t").getBytes());
            }
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try (FileInputStream reader = new FileInputStream(file)) {
            int i = reader.read();

            while (!(i == -1)) {
                System.out.print((char)i);

                i = reader.read();
            }
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
