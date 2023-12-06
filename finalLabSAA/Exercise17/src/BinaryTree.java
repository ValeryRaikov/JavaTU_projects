import java.util.HashSet;

public class BinaryTree {

    // Метод за проверка за дублиращи се стойности в дърво.
    public static boolean hasDuplicateValues(TreeNode root) {
        // Използваме HashSet за бърза проверка на уникалността на стойностите.
        HashSet<Integer> seenValues = new HashSet<>();

        // Помощен метод за рекурсивна проверка за дублиращи се стойности.
        return hasDuplicateValuesHelper(root, seenValues);
    }

    // Рекурсивен помощен метод за проверка за дублиращи се стойности.
    private static boolean hasDuplicateValuesHelper(TreeNode node, HashSet<Integer> seenValues) {
        // Ако достигнем листо или празно поддърво, няма какво да сравняваме.
        if (node == null) {
            return false;
        }

        // Ако вече сме видели стойността, значи има дублиране.
        if (seenValues.contains(node.value)) {
            return true;
        }

        // Добавяме стойността във HashSet.
        seenValues.add(node.value);

        // Проверяваме дали има дублиращи се стойности в лявото или дясното поддърво.
        boolean leftResult = hasDuplicateValuesHelper(node.left, seenValues);
        boolean rightResult = hasDuplicateValuesHelper(node.right, seenValues);

        // Връщаме резултатът от проверката в поддърветата.
        return leftResult || rightResult;
    }
    public static void printTree(TreeNode root) {
        printTreeHelper(root, 0);
    }

    // Рекурсивен помощен метод за извеждане на структурата на дървото.
    private static void printTreeHelper(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        // Извеждаме възела на текущото ниво и рекурсивно обхождаме лявото и дясното поддърво.
        System.out.println(" ".repeat(depth * 2) + node.value);
        printTreeHelper(node.left, depth + 1);
        printTreeHelper(node.right, depth + 1);
    }
}