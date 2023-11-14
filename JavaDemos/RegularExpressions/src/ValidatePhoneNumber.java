public interface ValidatePhoneNumber {
    static boolean ValidatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        if (!phoneNumber.matches("(\\+359|0)\\d{9}")) {
            throw new WrongPhoneNumberException("Error in phone number!");
        }

        System.out.println("Phone number satisfies conditions!");
        return true;
    }
}
