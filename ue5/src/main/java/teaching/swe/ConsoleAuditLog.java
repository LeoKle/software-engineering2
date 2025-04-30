package teaching.swe;

import java.util.List;

public class ConsoleAuditLog implements IAuditLog {
    @Override
    public void log(LogEntry entry) {
        System.out.println("Log: " + entry.type.toString() + " User: " + entry.name);
    }

    @Override
    public List<LogEntry> getLogs() {
        return null;
    }
}
