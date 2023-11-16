import java.io.*;
import java.util.ArrayList;

public class ProductLoader implements ImportData {
    private final String fileName;

    public ProductLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Object[] importDataFromFile() throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ArrayList<Product> products = new ArrayList<>();

            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof Product) {
                        products.add((Product) obj);
                    }
                }
                catch (ClassNotFoundException e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }
                catch (EOFException e) {
                    System.out.println("End of file reached!");
                    break;
                }
            }

            return products.toArray();
        }
    }
}