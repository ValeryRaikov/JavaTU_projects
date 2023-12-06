public class Test {
    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        System.out.println("Празен ли е цикличният списък преди добавяне на елементи: " + list.isEmpty());
        System.out.println("Размер на цикличния списък преди добавяне на елементи: " + list.size());

        // Добавяме елементи
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Празен ли е цикличният списък след добавяне на елементи: " + list.isEmpty());
        System.out.println("Размер на цикличния списък след добавяне на елементи: " + list.size());

        System.out.println("Оригинален списък:");
        list.print();

        list.doubleSizeIfNeeded();

        System.out.println("Списък след удвояване на размера, ако е необходимо:");
        list.print();
    }
}
