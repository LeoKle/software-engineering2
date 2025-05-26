package hsdinflab.swe.unit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import hsdinflab.swe.PasswordChecker;

public class PasswordCheckerTest {
    PasswordChecker passwordChecker;

    @BeforeEach
    public void setUp() {
        passwordChecker = new PasswordChecker();
    }

    @Nested
    class ValidPasswordTests {
        @Test
        public void testMinLengthPassword() {
            String password = "Abcdef1!";
            boolean result = passwordChecker.isValid(password);
            assertTrue(result);
        }

        @Test
        public void testMaxLengthPassword() {
            String password = "Abcdefghijklmnopqr1!";
            boolean result = passwordChecker.isValid(password);
            assertTrue(result);
        }

        @Test
        public void testRandomOrderPassword() {
            String password = "!Bcdefghijklmnopqr1!";
            boolean result = passwordChecker.isValid(password);
            assertTrue(result);
        }
    }

    @Nested
    class InvalidPasswordTests {
        @Test
        public void testPasswordTooShort() {
            String password = "Abcd1!";
            boolean result = passwordChecker.isValid(password);
            assertFalse(result);
        }

        @Test
        public void testPasswordTooLong() {
            String password = "Abcdefghijklmnopqrstuvw1!";
            boolean result = passwordChecker.isValid(password);
            assertFalse(result);
        }

        @Test
        public void testPasswordWithoutUpper() {
            String password = "abcdef1!";
            boolean result = passwordChecker.isValid(password);
            assertFalse(result);
        }

        @Test
        public void testPasswordWithoutLower() {
            String password = "ABCDEF1!";
            boolean result = passwordChecker.isValid(password);
            assertFalse(result);
        }

        @Test
        public void testPasswordWithoutDigit() {
            String password = "Abcdefg!";
            boolean result = passwordChecker.isValid(password);
            assertFalse(result);
        }

        @Test
        public void testPasswordWithoutSpecial() {
            String password = "ABCDEF1g";
            boolean result = passwordChecker.isValid(password);
            assertFalse(result);
        }
    }

    @Nested
    class EdgeCaseTests {
        @Test
        public void testOnNullEmail() {
            boolean result = passwordChecker.isValid(null);
            assertFalse(result);
        }

        @Test
        public void testWhitespaceEmail() {
            String password = "          ";
            boolean result = passwordChecker.isValid(password);
            assertFalse(result);
        }

        @Test
        public void testWithExtraSpecialCharsEmail() {
            String password = "Ab|''efgijklmnopqr1!";
            boolean result = passwordChecker.isValid(password);
            assertTrue(result);
        }

        @Test
        public void testOnEscapeCharactersEmail() {
            String password = "\t\t\t\t\t\t";
            boolean result = passwordChecker.isValid(password);
            assertFalse(result);
        }
    }
}
