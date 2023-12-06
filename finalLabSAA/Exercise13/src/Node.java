public class Node<T> {
    T data;
    Node<T> next;

    // Конструктор за инициализация на възел със зададени данни
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}