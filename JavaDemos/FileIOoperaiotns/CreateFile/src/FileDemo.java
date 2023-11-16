import java.io. *;
import java.util.Scanner;


public class FileDemo {
    public static void main(String[] args) {
        File file = new File("test_sample.txt");

        if (!file.exists()) {
            System.out.println("Creating your file...");
            try {
                file.createNewFile();
            }
            catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        else {
            System.out.println("Overriding your file...");
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your text here: ");

        String userInput;
        userInput = sc.nextLine();

        try (FileOutputStream writer = new FileOutputStream(file)) {
            writer.write(userInput.getBytes());
            writer.flush();

            writer.close();
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("Info from " + file.getName() + " is: ");
        try (FileInputStream reader = new FileInputStream(file)) {
            int i = reader.read();

            while (!(i == -1)) {
                System.out.print((char)i);

                i = reader.read();
            }
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
