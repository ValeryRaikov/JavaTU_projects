import java.io.Serializable;

public class Provider implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String phoneNumber;

    public Provider(String name, String phoneNumber) throws WrongPhoneNumberException {
        this.name = name;
        ValidatePhone.validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }

        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        ValidatePhone.validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
}