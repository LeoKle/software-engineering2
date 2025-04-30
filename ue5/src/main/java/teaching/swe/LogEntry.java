package teaching.swe;

public class LogEntry {
    public enum LogType {
        Add,
        Remove
    };

    public LogType type;
    public String name;

    public LogEntry(LogType type, String name) {
        this.type = type;
        this.name = name;
    }
}
