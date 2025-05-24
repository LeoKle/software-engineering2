package hsdinflab.swe.E2E;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import hsdinflab.swe.EmailChecker;
import hsdinflab.swe.PasswordChecker;
import hsdinflab.swe.RegistrationValidator;
import hsdinflab.swe.UsernameChecker;

public class RegistrationValidatorE2E {
    static final String valid_username = "validUser123";
    static final String valid_password = "Abcdefghijklmnopqr1!";
    static final String valid_email = "name@domain.de";
    static final String invalid_username = "abc";
    static final String invalid_password = "Abc";
    static final String invalid_email = "name@@domain.de";

    EmailChecker ec = new EmailChecker();
    PasswordChecker pc = new PasswordChecker();
    UsernameChecker uc = new UsernameChecker();
    RegistrationValidator rv = new RegistrationValidator(ec, pc, uc);;

    @Test
    public void testOnValidParameters() {
        boolean isUsernameValid = this.rv.validateUsername(valid_username);
        boolean isPasswordValid = this.rv.validatePassword(valid_password);
        boolean isEmailValid = this.rv.validateEmail(valid_email);

        boolean areCredentialsValid = this.rv.validate(valid_email, valid_password, valid_username);

        assertTrue(isUsernameValid);
        assertTrue(isPasswordValid);
        assertTrue(isEmailValid);
        assertTrue(areCredentialsValid);
    }

    @Test
    public void testOnInvalidParameters() {
        boolean isUsernameValid = this.rv.validateUsername(invalid_username);
        boolean isPasswordValid = this.rv.validatePassword(invalid_password);
        boolean isEmailValid = this.rv.validateEmail(invalid_email);

        boolean areCredentialsValid = this.rv.validate(invalid_email, invalid_password, invalid_username);

        assertFalse(isUsernameValid);
        assertFalse(isPasswordValid);
        assertFalse(isEmailValid);
        assertFalse(areCredentialsValid);
    }

    @Test
    public void testWithInvalidUsernameOnly() {
        boolean isUsernameValid = this.rv.validateUsername(invalid_username);
        boolean isPasswordValid = this.rv.validatePassword(valid_password);
        boolean isEmailValid = this.rv.validateEmail(valid_email);

        boolean areCredentialsValid = this.rv.validate(valid_email, valid_password, invalid_username);

        assertFalse(isUsernameValid);
        assertTrue(isPasswordValid);
        assertTrue(isEmailValid);
        assertFalse(areCredentialsValid);
    }

    @Test
    public void testWithInvalidPasswordOnly() {
        boolean isUsernameValid = this.rv.validateUsername(valid_username);
        boolean isPasswordValid = this.rv.validatePassword(invalid_password);
        boolean isEmailValid = this.rv.validateEmail(valid_email);

        boolean areCredentialsValid = this.rv.validate(valid_email, invalid_password, valid_username);

        assertTrue(isUsernameValid);
        assertFalse(isPasswordValid);
        assertTrue(isEmailValid);
        assertFalse(areCredentialsValid);
    }

    @Test
    public void testWithInvalidEmailOnly() {
        boolean isUsernameValid = this.rv.validateUsername(valid_username);
        boolean isPasswordValid = this.rv.validatePassword(valid_password);
        boolean isEmailValid = this.rv.validateEmail(invalid_email);

        boolean areCredentialsValid = this.rv.validate(invalid_email, valid_password, valid_username);

        assertTrue(isUsernameValid);
        assertTrue(isPasswordValid);
        assertFalse(isEmailValid);
        assertFalse(areCredentialsValid);
    }

    @Test
    public void testWithAllInvalidParameters() {
        boolean isUsernameValid = this.rv.validateUsername(invalid_username);
        boolean isPasswordValid = this.rv.validatePassword(invalid_password);
        boolean isEmailValid = this.rv.validateEmail(invalid_email);

        boolean areCredentialsValid = this.rv.validate(invalid_email, invalid_password, invalid_username);

        assertFalse(isUsernameValid);
        assertFalse(isPasswordValid);
        assertFalse(isEmailValid);
        assertFalse(areCredentialsValid);
    }
}
