public interface ValidateEmail {
    static boolean ValidateEmail(String email) throws WrongEmailException {
        if (!email.matches("\\w+\\@[a-z\\-]+\\.[a-z]+")) {
            throw new WrongEmailException("Error in email!");
        }

        System.out.println("Email satisfies conditions!");
        return true;
    }
}
