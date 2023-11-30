import java.util.*;
import java.util.stream.Collectors;

public class SortArray {
    public static void main(String[] args) {
        String[] carBrands = new String[]{
            "Volvo", "Skoda", "Mercedes", "Audi", "Subaru", "Opel", "Renault", "Nissan", "BMW"
        };

        int[] peopleAges = new int[]{
            42, 20, 26, 74, 51, 55, 32, 21, 80, 63, 12, 7, 38, 66
        };

        float[] studentGrades = new float[]{
            5.5f, 5.25f, 4.4f, 6.0f, 3.35f, 3.95f, 4.75f, 5.8f, 2.5f, 5.9f
        };

        System.out.println("Car brands: " + Arrays.toString(carBrands));
        System.out.println("People ages: " + Arrays.toString(peopleAges));
        System.out.println("Student grades: " + Arrays.toString(studentGrades));

        // I method of sorting in ascending order:
        Arrays.sort(carBrands);
        System.out.println("Sorted car brands: " + Arrays.toString(carBrands));
        Arrays.sort(peopleAges);
        System.out.println("Sorted people ages: " + Arrays.toString(peopleAges));
        Arrays.sort(studentGrades);
        System.out.println("Sorted student grades: " + Arrays.toString(studentGrades));

        // I method of sorting in descending order:
        Arrays.sort(carBrands, Collections.reverseOrder());
        System.out.println("Reverse sorted car brands: " + Arrays.toString(carBrands));

        Arrays.sort(peopleAges);
        int[] reversedPeopleAges = new int[peopleAges.length];
        for (int i = 0; i < peopleAges.length; i++) {
            reversedPeopleAges[i] = peopleAges[peopleAges.length - 1 - i];
        }
        System.out.println("Reverse sorted people ages: " + Arrays.toString(reversedPeopleAges));

        float[] reversedStudentGrades = new float[studentGrades.length];
        for (int i = 0; i < studentGrades.length; i++) {
            reversedStudentGrades[i] = studentGrades[studentGrades.length - 1 - i];
        }
        System.out.println("Reverse sorted student grades: " + Arrays.toString(reversedStudentGrades));

        // II method of sorting in ascending order:
        List<String> brands = new ArrayList<>(Arrays.asList(carBrands));
        List<Integer> ages = new ArrayList<>(Arrays.stream(peopleAges).boxed().toList());
        List<Float> grades = new ArrayList<>(List.of(5.5f, 5.25f, 4.4f, 6.0f, 3.35f, 3.95f, 4.75f, 5.8f, 2.5f, 5.9f));

        Collections.sort(brands);
        System.out.println("Sorted car brands: " + brands);
        Collections.sort(ages);
        System.out.println("Sorted people ages: " + ages);
        Collections.sort(grades);
        System.out.println("Sorted student grades: " + grades);

        // II method of sorting in descending order:
        brands.sort(Collections.reverseOrder());
        System.out.println("Reverse sorted car brands: " + brands);
        ages.sort(Collections.reverseOrder());
        System.out.println("Reverse sorted people ages: " + ages);
        grades.sort(Collections.reverseOrder());
        System.out.println("Reverse sorted student grades: " + grades);

        // III. Method of sorting in descending order:
        Arrays.sort(carBrands, (a, b) -> b.compareTo(a));
        System.out.println("Reverse sorted car brands: " + Arrays.toString(carBrands));

        int[] reversedAges = Arrays.stream(peopleAges).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("Reverse sorted people ages: " + Arrays.toString(reversedPeopleAges));

    }
}
