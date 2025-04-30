package teaching.swe;

import teaching.swe.LogEntry;
import teaching.swe.LogEntry.LogType;;

public class UserManagerWithAudit extends SimpleUserManager {
    IAuditLog logger;

    public UserManagerWithAudit(IAuditLog logger) {
        this.logger = logger;
    }

    @Override
    public void addUser(String name) {
        if (name == null)
            return;

        if (users.contains(name))
            return;

        users.add(name);
        logger.log(new LogEntry(LogType.Add, name));
    }

    @Override
    public void removeUser(String name) {
        if (name == null)
            return;

        if (!users.contains(name))
            return;

        users.removeIf(user -> user.equals(name));
        logger.log(new LogEntry(LogType.Remove, name));
    }
}
