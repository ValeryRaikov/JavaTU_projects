public class Test {
    public static void main(String[] args) {
        // Създаваме двоично дърво с дублираща се стойност в лявото поддърво.
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);  // Дублираща стойност.
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Структура на дървото:");
        BinaryTree.printTree(root);

        // Извикваме метода за проверка за дублиращи се стойности.
        boolean hasDuplicates = BinaryTree.hasDuplicateValues(root);

        // Извеждаме резултата от проверката.
        if (hasDuplicates) {
            System.out.println("В дървото има поне два върха с еднакви стойности.");
        } else {
            System.out.println("В дървото няма два върха с еднакви стойности.");
        }
    }
}
