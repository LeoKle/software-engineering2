package hsdinflab.swe;

public class RegistrationValidator {

    private final EmailChecker emailChecker;
    private final PasswordChecker passwordChecker;
    private final UsernameChecker usernameChecker;

    public RegistrationValidator(EmailChecker emailChecker,
                                 PasswordChecker passwordChecker,
                                 UsernameChecker usernameChecker) {
        this.emailChecker = emailChecker;
        this.passwordChecker = passwordChecker;
        this.usernameChecker = usernameChecker;
    }

    public boolean validateEmail(String email) {
        return emailChecker.isValid(email);
    }

    public boolean validatePassword(String password) {
        return passwordChecker.isValid(password);
    }

    public boolean validateUsername(String username) {
        return usernameChecker.isValid(username);
    }

    public boolean validate(String email, String password, String username) {
        return validateEmail(email)
            && validatePassword(password)
            && validateUsername(username);
    }
}