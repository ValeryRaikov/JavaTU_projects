import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Voter> voters = new ArrayList<>();

//        try {
//            voters.add(new Voter("Valery Raikov", "Sofia", "Samara", "Mladost 4"));
//            voters.add(new Voter("Petar Stamenov", "Plovdiv", "Buzludzha", "Komatevo"));
//            voters.add(new Voter("Dimitar Petkov", "Sofia", "Tsar Boris", "Dianabad"));
//            voters.add(new Voter("Mihail Ivanov", "Stara Zagora", "Shishmantsi", "Suedinenie"));
//        }
//        catch (IllegalArgumentException e) {
//            System.err.println("Error creating voter! " + e.getMessage());
//        }

        try {
            while (true) {
                System.out.println("Choose one of the following options:");
                System.out.println("1.)Create voter:\n2.)Quit creation:");

                int option = sc.nextInt();

                if (option == 1) {
                    voters.add(Voter.createVoter(sc));
                }
                else if (option == 2) {
                    System.out.println("Voter creation disrupted!");
                    break;
                }
                else {
                    System.out.println("Wrong user input! Enter again:");
                }
            }
        }
        catch (IllegalArgumentException e) {
            System.err.println("Error creating voter! " + e.getMessage());
        }

        // Get all voters who are not from Sofia:
        List<Voter> sofiaVoters = voters.stream()
                .filter(voter -> !voter.getCity().equals("Sofia"))
                .sorted(Comparator.comparing(Voter::getStreet)
                .thenComparing(Voter::getAddress)).toList();

        System.out.println("All voters excluding Sofia:");
        sofiaVoters.forEach(System.out::println);
    }
}