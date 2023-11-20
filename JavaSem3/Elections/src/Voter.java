import java.util.Scanner;

public class Voter {
    private String name;
    private String city;
    private String street;
    private String address;

    public Voter(String name, String city, String street, String address) throws IllegalArgumentException {
        setName(name);
        setCity(city);
        setStreet(street);
        setAddress(address);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) throws IllegalArgumentException {
        validateString(newName, "Name");

        this.name = newName;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String newCity) throws IllegalArgumentException {
        validateString(newCity, "City");

        this.city = newCity;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String newStreet) throws IllegalArgumentException {
        validateString(newStreet, "Street");

        this.street = newStreet;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String newAddress) throws IllegalArgumentException {
        validateString(newAddress, "Address");

        this.address = newAddress;
    }

    private void validateString(String value, String fieldName) throws IllegalArgumentException {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be an empty string!");
        }
    }

    @Override
    public String toString() {
        return "Voter{" +
                "name='" + this.name +
                ", city='" + this.city +
                ", street='" + this.street +
                ", address='" + this.address +
                "}";
    }

    public static Voter createVoter(Scanner sc) throws  IllegalArgumentException {
        sc.nextLine();
        System.out.print("Enter voter name: ");
        String name = sc.nextLine();
        System.out.print("Enter voter city: ");
        String city = sc.nextLine();
        System.out.print("Enter voter street: ");
        String street = sc.nextLine();
        System.out.print("Enter voter address: ");
        String address = sc.nextLine();

        try {
            return new Voter(name, city, street, address);
        }
        catch (IllegalArgumentException e) {
            System.err.println("Error creating voter! " + e.getMessage());
            return null;
        }

    }
}
