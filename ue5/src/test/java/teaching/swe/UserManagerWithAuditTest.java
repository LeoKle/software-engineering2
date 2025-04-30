package teaching.swe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserManagerWithAuditTest {
    private SimpleUserManager um;
    private IAuditLog logger;

    @BeforeEach
    void setUp() {
        this.logger = new InMemoryAuditLog();
        this.um = new UserManagerWithAudit(logger);
    }

    @Test
    void testAddNullUserDoesNotChangeList() {
        this.um.addUser(null);
        assertEquals(0, um.getUsers().size());

        assertEquals(0, logger.getLogs().size());
    }

    @Test
    void testRemoveUserOnEmptyListDoesNothing() {
        this.um.removeUser("non-existent-user");
        assertEquals(0, um.getUsers().size());

        assertEquals(0, logger.getLogs().size());
    }

    @Test
    void testRemoveNullDoesNothing() {
        this.um.removeUser(null);
        assertEquals(0, um.getUsers().size());

        assertEquals(0, logger.getLogs().size());
    }

    @Test
    void testAddSingleUser() {
        this.um.addUser("user1");
        assertEquals(1, um.getUsers().size());
        assertTrue(um.getUsers().contains("user1"));

        assertEquals(1, logger.getLogs().size());
    }

    @Test
    void testAddDuplicateUsers() {
        this.um.addUser("user1");
        this.um.addUser("user1");
        assertEquals(1, um.getUsers().size());

        assertEquals(1, logger.getLogs().size());
    }

    @Test
    void testRemoveExistingUser() {
        this.um.addUser("user1");
        this.um.removeUser("user1");
        assertEquals(0, um.getUsers().size());

        assertEquals(2, logger.getLogs().size());
    }

    @Test
    void testRemoveSameUserTwice() {
        this.um.addUser("user1");
        this.um.removeUser("user1");
        this.um.removeUser("user1"); // should do nothing
        assertEquals(0, um.getUsers().size());
        assertEquals(2, logger.getLogs().size());
    }

    @Test
    void testAddMultipleUsersAndRemoveInOrder() {
        this.um.addUser("user1");
        this.um.addUser("user2");
        this.um.addUser("user3");

        assertEquals(3, um.getUsers().size());
        assertEquals(3, logger.getLogs().size());

        this.um.removeUser("user1");
        assertEquals(2, um.getUsers().size());
        assertEquals(4, logger.getLogs().size());

        this.um.removeUser("user2");
        assertEquals(1, um.getUsers().size());
        assertEquals(5, logger.getLogs().size());

        this.um.removeUser("user3");
        assertEquals(0, um.getUsers().size());
        assertEquals(6, logger.getLogs().size());
    }

    @Test
    void testAddAndRemoveOutOfOrder() {
        this.um.addUser("user1");
        this.um.addUser("user2");
        this.um.addUser("user3");

        this.um.removeUser("user2");
        assertEquals(2, um.getUsers().size());
        assertEquals(4, logger.getLogs().size());
        assertTrue(um.getUsers().contains("user1"));
        assertTrue(um.getUsers().contains("user3"));
    }
}
