import java.util.Scanner;
import java.util.Arrays;

public class JavaArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = sc.nextInt();

        int[] originalArray = new int[size];

        System.out.println("Fill the array with " + size + " numbers: ");
        for (int i = 0; i < size; ++i) {
            System.out.print("Enter number at pos [" + i + "]: ");
            originalArray[i] = sc.nextInt();
        }

        System.out.print("Enter key value to check: ");
        int key = sc.nextInt();

        int[] sortedAndFilteredArray = sortAndFilter(originalArray, key);

        System.out.println("Original array: " + Arrays.toString(originalArray));
        System.out.println("Sorted and filtered array: " + Arrays.toString(sortedAndFilteredArray));
    }

    public static int[] sortAndFilter(int[] array, int key) {
        int[] copiedArray = Arrays.copyOf(array, array.length);

        Arrays.sort(copiedArray);

        int indexToKeep = 0;
        while (indexToKeep < copiedArray.length && copiedArray[indexToKeep] <= key) {
            indexToKeep++;
        }

        int[] resultArray = Arrays.copyOfRange(copiedArray, 0, indexToKeep);

        return resultArray;
    }
}
