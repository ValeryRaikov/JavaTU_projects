class User implements ValidatePhone {
    private String username;
    private String password;
    private String phoneNumber;

    public User(String username, String password, String phoneNumber) throws WrongUserException, WrongPhoneNumberException {
        try {
//            method 1:
//            validateUsername(username);
//            validatePassword(password);
//            ValidatePhone.validatePhoneNumber(phoneNumber);

//            method 2:
            setUsername(username);
            setPassword(password);
            setPhoneNumber(phoneNumber);

            this.username = getUsername();
            this.password = getPassword();
            this.phoneNumber = getPhoneNumber();
        }
        catch (WrongUserException | WrongPhoneNumberException e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws WrongUserException {
        validateUsername(username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws WrongUserException {
        validatePassword(password);
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        ValidatePhone.validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private void validateUsername(String username) throws WrongUserException {
        if (!username.matches("[a-z0-9_-]{3,15}")) {
            throw new WrongUserException("Invalid username.");
        }

        System.out.println("Username satisfies conditions!");
    }

    private void validatePassword(String password) throws WrongUserException {
        if (!password.matches("[a-zA-Z]{11,}")) {
            throw new WrongUserException("Invalid password.");
        }

        System.out.println("Password satisfies conditions!");
    }
}