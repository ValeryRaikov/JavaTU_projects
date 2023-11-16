import java.io.*;

public class FileGenerator {
    public static void main(String[] args) {
        Electronics electronics1 = null;
        Electronics electronics2 = null;
        Book book1 = null;
        Book book2 = null;

        try {
            electronics1 = new Electronics(1, 1500.0, 200, new Provider("K&K Electronics LTD", "0878457123"), "LG", "86UH955V");
            electronics2 = new Electronics(1, 1590.99, 300, new Provider("K&K Electronics LTD", "0878457123"), "Dell", "ALIENWARE 15");
            book1 = new Book(2, 25.99, 1000, new Provider("Ciela LTD", "0878453453"), "Terry Pratchett", "Small Gods");
            book2 = new Book(2, 16.78, 950, new Provider("Bard LTD", "0884345098"), "Timothy Zahn", "Star Wars: Heir to the Empire");
        }
        catch (WrongPhoneNumberException e) {
            System.err.println(e.getMessage());
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("salesproducts.txt"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("salesproducts.txt"), "UTF-8"))) {

            oos.writeObject(electronics1);
            oos.writeObject(electronics2);
            oos.writeObject(book1);
            oos.writeObject(book2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
