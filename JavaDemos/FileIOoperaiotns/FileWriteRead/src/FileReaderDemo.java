import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test_output.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println("Unexpected exception: " + e.getMessage());
        }
    }
}
