interface ValidatePassword {
    static boolean ValidatePassword(String password) throws WrongPasswordException {
        if (!password.matches("[\\w\\.\\-\\;]{8,}")) {
            throw new WrongPasswordException("Error in password!");
        }

        System.out.println("Password satisfies conditions!");
        return true;
    }
}
