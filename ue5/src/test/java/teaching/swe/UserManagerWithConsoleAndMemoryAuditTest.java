package teaching.swe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserManagerWithConsoleAndMemoryAuditTest {
    private UserManagerWithAudit um;
    private IAuditLog memoryLogger;
    private IAuditLog consoleLogger;

    @BeforeEach
    void setUp() {
        this.memoryLogger = new InMemoryAuditLog();
        this.consoleLogger = new ConsoleAuditLog();
        this.um = new UserManagerWithAudit(memoryLogger);
    }

    @Test
    void testChangeLogger() {
        this.um.changeLogger(this.consoleLogger);

        // no exception should be thrown after changing the logger and a log is caused
        this.um.addUser("test");
        this.um.removeUser("test");

        this.um.changeLogger(this.memoryLogger);
        this.um.addUser("test");
        this.um.removeUser("test");
    }
}
