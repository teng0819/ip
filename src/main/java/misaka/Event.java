package misaka;

/**
 * Represents a task that occurs during a specific time period.
 */

public class Event extends Task {
    private final String from;
    private final String to;

    /**
     * Creates an event task.
     *
     * @param description Description of the event
     * @param from Start time of the event
     * @param to End time of the event
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the string representation of the event task.
     *
     * @return Formatted event task string
     */
    public String toString() {
        return "[E]["
                + statusIcon()
                + "] "
                + description
                + " (from: "
                + from
                + " to: "
                + to
                + ")";
    }

    /**
     * Converts the event task to a file storage format.
     *
     * @return File-format string of the event task
     */
    public String toFileString() {
        return "E | "
                + (isDone ? 1 : 0)
                + " | "
                + description
                + " | "
                + from
                + " | "
                + to;
    }
}
