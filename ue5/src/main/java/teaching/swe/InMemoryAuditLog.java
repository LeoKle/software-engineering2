package teaching.swe;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAuditLog implements IAuditLog {
    private List<LogEntry> logs = new ArrayList<LogEntry>();

    @Override
    public void log(LogEntry entry) {
        this.logs.add(entry);
    }

    @Override
    public List<LogEntry> getLogs() {
        return this.logs;
    }
}
