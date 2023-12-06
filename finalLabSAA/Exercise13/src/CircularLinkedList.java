public class CircularLinkedList<T> {
    private Node<T> head;
    private int size;

    // Конструктор за инициализация на празен кръгов свързан списък
    public CircularLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Метод за връщане на размера на списъка
    public int size() {
        return size;
    }

    // Метод за проверка дали списъкът е празен
    public boolean isEmpty() {
        return size == 0;
    }

    // Метод за добавяне на нов елемент към списъка
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            // Ако списъкът е празен, правим новия възел глава и сочим към себе си
            head = newNode;
            head.next = head;
        } else {
            // Ако списъкът не е празен, вмъкваме новия възел след главата
            newNode.next = head.next;
            head.next = newNode;
        }
        size++;
    }

    // Метод за удвояване на размера на списъка, ако е необходимо
    public void doubleSizeIfNeeded() {
        if (size == 0) {
            return;
        }
        Node<T> current = head;
        int count = 1;
        while (count < size) {
            current = current.next;
            count++;
        }
        current.next = head; // Правим списъка кръгов

        if (size * 2 >= count) {
            return;
        }

        // Удвояване на размера, като създадем нов списък и копираме елементите
        Node<T> newHead = null;
        Node<T> tail = null;
        current = head;
        count = 0;
        while (count < size) {
            Node<T> newNode = new Node<>(current.data);
            if (newHead == null) {
                newHead = newNode;
                tail = newHead;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            current = current.next;
            count++;
        }
        tail.next = newHead;
        head = newHead;
    }

    // Метод за извеждане на елементите на списъка
    public void print() {
        if (size == 0) {
            return;
        }
        Node<T> current = head;
        int count = 0;
        do {
            System.out.print(current.data + " ");
            current = current.next;
            count++;
        } while (count < size);
        System.out.println();
    }
}
