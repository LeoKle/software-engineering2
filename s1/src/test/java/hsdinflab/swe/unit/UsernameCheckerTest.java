package hsdinflab.swe.unit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import hsdinflab.swe.UsernameChecker;

public class UsernameCheckerTest {

    
    private UsernameChecker usernameChecker = new UsernameChecker();

    // @BeforeAll
    // public static void setUp() {
    //     usernameChecker = new UsernameChecker();
    // }

    @Nested
    class ValidUsernameTests {
        @Test
        public void testOnValidUsername() {
            String username = "validUser123";
            boolean result = usernameChecker.isValid(username);
            assertTrue(result);
        }

        @Test
        public void testOnUsernameWithUnderscore() {
            String username = "user_name";
            boolean result = usernameChecker.isValid(username);
            assertTrue(result);
        }


        @Test
        public void testOnUsernameWithNumbers() {
            String username = "123456789";
            boolean result = usernameChecker.isValid(username);
            assertTrue(result);
        }

        @Test
        public void testOnUsernameWithOnlyAlphabets() {
            String username = "abcdefg";
            boolean result = usernameChecker.isValid(username);
            assertTrue(result);
        }
    }

    @Nested
    class InvalidUsernameTests {
        @Test
        public void testOnEmptyUsername() {
            String username = "";
            boolean result = usernameChecker.isValid(username);
            assertFalse(result);
        }

        @Test
        public void testOnNullUsername() {
            String username = null;
            boolean result = usernameChecker.isValid(username);
            assertFalse(result);
        }

        @Test
        public void testOnBlankUsername() {
            String username = "      ";
            boolean result = usernameChecker.isValid(username);
            assertFalse(result);
        }

        @Test
        public void testOnUsernameWithSpace() {
            String username = "user name";
            boolean result = usernameChecker.isValid(username);
            assertFalse(result);
        }        

        @Test
        public void testOnUsernameWithSpecialChars() {
            String username = "user@name";
            boolean result = usernameChecker.isValid(username);
            assertFalse(result);
        }

        @Test
        public void testOnUsernameWithExclaimationmark() {
            String username = "username!";
            boolean result = usernameChecker.isValid(username);
            assertFalse(result);
        }        

        @Test
        public void testOnTooShortUsername() {
            String username = "abc";
            boolean result = usernameChecker.isValid(username);
            assertFalse(result);
        }

        @Test
        public void testOnTooLongUsername() {
            String username = "thisusernameiswaytoolongtobevalid";
            boolean result = usernameChecker.isValid(username);
            assertFalse(result);
        }

        @Test
        public void testOnUsernameWithHyphen() {
            String username = "user-name";
            boolean result = usernameChecker.isValid(username);
            assertFalse(result);
        }
    }
    
    @Nested
    class EdgeCaseTests {
        @Test
        public void testOnUsernameWithLeadingAndTrailingSpaces() {
            String username = "  validUser  ";
            boolean result = usernameChecker.isValid(username);
            assertFalse(result);
        }

        @Test
        public void testOnUsernameWithMultipleUndercores() {
            String username = "Valid__User";
            boolean result = usernameChecker.isValid(username);
            assertTrue(result);
        }

        @Test
        public void testOnUsernameWith3Chars() {
            String username = "abc";
            boolean result = usernameChecker.isValid(username);
            assertFalse(result);
        }

        @Test
        public void testOnUsernameWith4Chars() { //min
            String username = "abcd";
            boolean result = usernameChecker.isValid(username);
            assertTrue(result);
        }

        @Test
        public void testOnUsernameWith5Chars() {
            String username = "abcdr";
            boolean result = usernameChecker.isValid(username);
            assertTrue(result);
        }      
        
        @Test
        public void testOnUsernameWith14Chars() {
            String username = "username123456";
            boolean result = usernameChecker.isValid(username);
            assertTrue(result);
        }

        @Test
        public void testOnUsernameWith15Chars() { //max
            String username = "username1234567";
            boolean result = usernameChecker.isValid(username);
            assertTrue(result);
        }
        
        @Test
        public void testOnUsernameWith16Chars() {
            String username = "username12345678";
            boolean result = usernameChecker.isValid(username);
            assertFalse(result);
        }        

        @Test
        public void testOnUsernameWithNonEnglishCharacters() {
            String username = "用户123";
            boolean result = usernameChecker.isValid(username);
            assertTrue(result);
        }  
    }
}
