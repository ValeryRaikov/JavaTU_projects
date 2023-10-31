import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class IncorrectFileNameException extends RuntimeException {
    public IncorrectFileNameException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}

class IncorrectFileExtensionException extends RuntimeException {
    public IncorrectFileExtensionException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}

public class CustomException {
    public static String readFromFile(String fileName) {
        try (Scanner file = new Scanner(new File(fileName))) {
            if (file.hasNextLine()) {
                return file.nextLine();
            } else {
                throw new IllegalArgumentException("Non-readable file");
            }
        }
        catch (FileNotFoundException err) {
            if (!isCorrectFileName(fileName)) {
                throw new IncorrectFileNameException("Incorrect filename: " + fileName, err);
            }

        }
        catch (IllegalArgumentException err) {
            if (!containsExtension(fileName)) {
                throw new IncorrectFileExtensionException("Filename does not contain extension: " + fileName, err);
            }
        }
        return null;
    }

    public static boolean isCorrectFileName(String fileName) {
        //TODO logic here
        return true;
    }

    public static boolean containsExtension(String fileName) {
        ////TODO logic here
        return true;
    }

    public static void main(String[] args) {
        String fileName = "example.txt";
        try {
            String content = readFromFile(fileName);
            System.out.println("File content: " + content);
        } catch (IncorrectFileNameException | IncorrectFileExtensionException e) {
            e.printStackTrace();
        }
    }
}
