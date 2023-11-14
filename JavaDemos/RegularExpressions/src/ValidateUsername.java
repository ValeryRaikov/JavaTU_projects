public interface ValidateUsername {
    static boolean ValidateUsername(String username) throws WrongUsernameException {
        if (!username.matches("\\w{8,16}")) {
            throw new WrongUsernameException("Error in username!");
        }

        System.out.println("Username satisfies conditions.");
        return true;
    }
}
