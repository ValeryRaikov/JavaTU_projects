import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*System.out.print("Enter patient name: ");
        String name = sc.nextLine();
        System.out.print("Enter patient address: ");
        String address = sc.nextLine();
        System.out.print("Enter patient EGN: ");
        String egn = sc.nextLine();
        System.out.print("Enter patient epicrisis: ");
        String epicrisis = sc.nextLine();
        System.out.print("Enter patient day of illness: ");
        int dayOfIllness = sc.nextInt();

        SickPatient sickPatient1 = new SickPatient(name, address, egn, epicrisis, dayOfIllness);*/
        SickPatient sickPatient2 = new SickPatient("Ivan Petrov", "Mladost 3", "0345137850", "HIV", 10);
        SickPatient sickPatient3 = new SickPatient("Dimitar Penchev", "Nadezhda", "9142107561", "Coronavirus", 4);

        SickPatient[] hospital = {sickPatient2, sickPatient3};

        for (SickPatient sickPatient: hospital) {
            System.out.println(sickPatient);
        }

        System.out.println(sickPatient2.cure("Antibiotics", 1));

    }
}
