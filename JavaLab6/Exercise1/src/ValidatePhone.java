public interface ValidatePhone {
    static boolean validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        if (phoneNumber.matches("[0]\\d{9}")) {
            return true;
        } else {
            throw new WrongPhoneNumberException("Invalid phone number!");
        }
    }
}