package teaching.swe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleUserManagerTest {
    private SimpleUserManager um;

    @BeforeEach
    void setUp() {
        this.um = new SimpleUserManager();
    }

    @Test
    void testAddNullUserDoesNotChangeList() {
        this.um.addUser(null);
        assertEquals(0, um.getUsers().size());
    }

    @Test
    void testRemoveUserOnEmptyListDoesNothing() {
        this.um.removeUser("non-existent-user");
        assertEquals(0, um.getUsers().size());
    }

    @Test
    void testRemoveNullDoesNothing() {
        this.um.removeUser(null);
        assertEquals(0, um.getUsers().size());
    }

    @Test
    void testAddSingleUser() {
        this.um.addUser("user1");
        assertEquals(1, um.getUsers().size());
        assertTrue(um.getUsers().contains("user1"));
    }

    @Test
    void testAddDuplicateUsers() {
        this.um.addUser("user1");
        this.um.addUser("user1");
        assertEquals(2, um.getUsers().size());
    }

    @Test
    void testRemoveExistingUser() {
        this.um.addUser("user1");
        this.um.removeUser("user1");
        assertEquals(0, um.getUsers().size());
    }

    @Test
    void testRemoveSameUserTwice() {
        this.um.addUser("user1");
        this.um.removeUser("user1");
        this.um.removeUser("user1"); // should do nothing
        assertEquals(0, um.getUsers().size());
    }

    @Test
    void testAddMultipleUsersAndRemoveInOrder() {
        this.um.addUser("user1");
        this.um.addUser("user2");
        this.um.addUser("user3");

        assertEquals(3, um.getUsers().size());

        this.um.removeUser("user1");
        assertEquals(2, um.getUsers().size());

        this.um.removeUser("user2");
        assertEquals(1, um.getUsers().size());

        this.um.removeUser("user3");
        assertEquals(0, um.getUsers().size());
    }

    @Test
    void testAddAndRemoveOutOfOrder() {
        this.um.addUser("user1");
        this.um.addUser("user2");
        this.um.addUser("user3");

        this.um.removeUser("user2");
        assertEquals(2, um.getUsers().size());
        assertTrue(um.getUsers().contains("user1"));
        assertTrue(um.getUsers().contains("user3"));
    }
}
