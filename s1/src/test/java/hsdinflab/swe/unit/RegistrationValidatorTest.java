package hsdinflab.swe.unit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import hsdinflab.swe.EmailChecker;
import hsdinflab.swe.PasswordChecker;
import hsdinflab.swe.RegistrationValidator;
import hsdinflab.swe.UsernameChecker;

public class RegistrationValidatorTest {
    EmailChecker emailChecker = new EmailChecker();;
    PasswordChecker passwordChecker = new PasswordChecker();
    UsernameChecker usernameChecker = new UsernameChecker();
    RegistrationValidator validator = new RegistrationValidator(emailChecker, passwordChecker, usernameChecker);

    @Test
    public void testValidRegistration() {
    String email = "name@domain.de";
    String password = "Abcdef1!";
    String username = "validUser123";
    boolean result = validator.validate(email, password, username);
    assertTrue(result);
    }

    @Test
    public void testInvalidEmail() {
        String email = "name1.name2.de";
        String password = "Abcdef1!";
        String username = "validUser123";
        boolean result = validator.validate(email, password, username);
        assertFalse(result);
    }

    @Test
    public void testInvalidPassword() {
        String email = "name@domain.de";
        String password = "Abcd1!";
        String username = "validUser123";
        boolean result = validator.validate(email, password, username);
        assertFalse(result);
    }
    
    @Test
    public void testInvalidUsername() {
        String email = "name@domain.de";
        String password = "Abcdef1!";
        String username = "user name";
        boolean result = validator.validate(email, password, username);
        assertFalse(result);
    }
    
    @Test
    public void testInvalidEmailNull() {
        String email = null;
        String password = "Abcdef1!";
        String username = "user name";
        boolean result = validator.validate(email, password, username);
        assertFalse(result);
    }    
    @Test
    public void testInvalidPasswordNull() {
        String email = "name@domain.de";
        String password = null;
        String username = "user name";
        boolean result = validator.validate(email, password, username);
        assertFalse(result);
    }     
    
    @Test
    public void testInvalidUsernameNull() {
        String email = "name@domain.de";
        String password = "Abcdef1!";
        String username = null;
        boolean result = validator.validate(email, password, username);
        assertFalse(result);
    }  
    
    @Test
    public void testInvalid() {
        String email = "   ";
        String password = null;
        String username = "user name";
        boolean result = validator.validate(email, password, username);
        assertFalse(result);
    }     
}
