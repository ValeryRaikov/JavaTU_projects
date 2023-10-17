public class Test {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop(19.5, "Intel i7", 16, 512);
        Laptop laptop2 = new Laptop(20, "AMD Ryzen 9", 32, 1024);

        System.out.println("Laptop 1:");
        System.out.println(laptop1);
        System.out.println();

        System.out.println("Laptop 2:");
        System.out.println(laptop2);
        System.out.println();

        if (laptop1.isBetter(laptop2)) {
            System.out.println("Laptop 1 is better than laptop 2!");
        } else {
            System.out.println("Laptop 2 is better than laptop 1!");
        }
    }
}
