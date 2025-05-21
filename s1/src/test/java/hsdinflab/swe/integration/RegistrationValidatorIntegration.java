package hsdinflab.swe.integration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hsdinflab.swe.EmailChecker;
import hsdinflab.swe.PasswordChecker;
import hsdinflab.swe.RegistrationValidator;
import hsdinflab.swe.UsernameChecker;
import hsdinflab.swe.mocks.UsernameCheckerMock;

public class RegistrationValidatorIntegration {
    static final String valid_username = "Abcdef";
    static final String valid_password = "Abcdefghijklmnopqr1!";
    static final String valid_email = "name@domain.de";
    static final String invalid_username = "Abc";
    static final String invalid_password = "Abc";
    static final String invalid_email = "name@@domain.de";

    RegistrationValidator rv;
    EmailChecker ec = new EmailChecker();
    PasswordChecker pc = new PasswordChecker();
    UsernameCheckerMock uc = new UsernameCheckerMock();

    @BeforeEach
    public void setUp() {
        this.ec = new EmailChecker();
        this.pc = new PasswordChecker();
        this.uc = new UsernameCheckerMock();

        this.rv = new RegistrationValidator(ec, pc, uc);
    }

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
        this.uc.setReturnValue(false);
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
        this.uc.setReturnValue(false);
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
        this.uc.setReturnValue(true);
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
        this.uc.setReturnValue(true);
        boolean isUsernameValid = this.rv.validateUsername(valid_username);
        boolean isPasswordValid = this.rv.validatePassword(valid_password);
        boolean isEmailValid = this.rv.validateEmail(invalid_email);

        boolean areCredentialsValid = this.rv.validate(invalid_email, valid_password, valid_username);

        assertTrue(isUsernameValid);
        assertTrue(isPasswordValid);
        assertFalse(isEmailValid);
        assertFalse(areCredentialsValid);
    }
}
