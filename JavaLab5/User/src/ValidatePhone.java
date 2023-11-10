interface ValidatePhone {
    static boolean validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        if (!phoneNumber.matches("\\+359\\d{2}\\d{7}")) {
            throw new WrongPhoneNumberException("Invalid phone number. Must contain only digits!");
        }

        System.out.println("Phone number satisfies conditions!");

        return true;
    }
}