package hsdinflab.swe.unit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import hsdinflab.swe.EmailChecker;

public class EmailCheckerTest {
    EmailChecker emailChecker;

    @BeforeEach
    public void setUp() {
        emailChecker = new EmailChecker();
    }

    @Nested
    class ValidEmailTests {
        @Test
        public void testOnSimpleEmail() {
            String email = "name@domain.de";
            boolean result = emailChecker.isValid(email);
            assertTrue(result);
        }

        @Test
        public void testOnDotEmail() {
            String email = "name.name@domain.de";
            boolean result = emailChecker.isValid(email);
            assertTrue(result);
        }

        @Test
        public void testOnSpecialCharsEmail() {
            String email = "name-name@domain.com";
            boolean result = emailChecker.isValid(email);
            assertTrue(result);
        }

        @Test
        public void testOnSpecialChars2Email() {
            String email = "name!name@domain.com";
            boolean result = emailChecker.isValid(email);
            assertTrue(result);
        }

        @Test
        public void testOnSubdomainEmail() {
            String email = "name@adresse.subdomain.org";
            boolean result = emailChecker.isValid(email);
            assertTrue(result);
        }

        @Test
        public void testOnEmailWithTag() {
            String email = "name1.name2+tag@adresse.com";
            boolean result = emailChecker.isValid(email);
            assertTrue(result);
        }

        @Test
        public void testOnEmailWithSpecialCharacters() {
            String email = "name!@adresse.com";
            boolean result = emailChecker.isValid(email);
            assertTrue(result);
        }
    }

    @Nested
    class InvalidEmailTests {
        @Test
        public void testOnEmailWithoutAtSymbol() {
            String email = "name1.name2.de";
            boolean result = emailChecker.isValid(email);
            assertFalse(result);
        }

        @Test
        public void testOnEmailWithMultipleAtSymbols() {
            String email = "name.@@domain.de";
            boolean result = emailChecker.isValid(email);
            assertFalse(result);
        }

        @Test
        public void testOnEmailWithoutLocal() {
            String email = " @withoutlocal.de";
            boolean result = emailChecker.isValid(email);
            assertFalse(result);
        }

        @Test
        public void testOnEmailWithoutDomain() {
            String email = "withoutDomain@";
            boolean result = emailChecker.isValid(email);
            assertFalse(result);
        }

        @Test
        public void testOnEmailWithoutDomainTopLevel() {
            String email = "name@domain";
            boolean result = emailChecker.isValid(email);
            assertFalse(result);
        }

        @Test
        public void testOnEmailWithPartialDomainTopLevel() {
            String email = "name@domain.";
            boolean result = emailChecker.isValid(email);
            assertFalse(result);
        }

        @Test
        public void testOnEmailWithSpaces() {
            String email = "name1 @name2.com";
            boolean result = emailChecker.isValid(email);
            assertFalse(result);
        }

        @Test
        public void testOnEmailWithoutDomainOrLocalPart() {
            String email = "@";
            boolean result = emailChecker.isValid(email);
            assertFalse(result);
        }
    }

    @Nested
    class EdgeCaseTests {
        @Test
        public void testOnEmptyEmail() {
            String email = "";
            boolean result = emailChecker.isValid(email);
            assertFalse(result);
        }

        @Test
        public void testOnNullEmail() {
            String email = null;
            boolean result = emailChecker.isValid(email);
            assertFalse(result);
        }

        @Test
        public void testOnWhitestringEmail() {
            String email = "      ";
            boolean result = emailChecker.isValid(email);
            assertFalse(result);
        }

        @Test
        public void testOnEscapeCharactersEmail() {
            String email = "\n\t";
            boolean result = emailChecker.isValid(email);
            assertFalse(result);
        }
    }
}
