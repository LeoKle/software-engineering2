package teaching.swe;

import java.util.List;

public interface IAuditLog {
    public void log(LogEntry entry);

    public List<LogEntry> getLogs();
}
