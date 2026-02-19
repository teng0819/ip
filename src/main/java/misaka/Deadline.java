package misaka;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task that must be completed by a specific date.
 */
public class Deadline extends Task {

    private static final DateTimeFormatter OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("MMM dd yyyy");

    private final LocalDate by;

    /**
     * Creates a deadline task.
     *
     * @param description Description of the task
     * @param by Due date of the task
     */
    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the string representation of the deadline task.
     *
     * @return Formatted deadline task string
     */
    @Override
    public String toString() {
        return "[D]["
                + statusIcon()
                + "] "
                + description
                + " (by: "
                + by.format(OUTPUT_FORMAT)
                + ")";
    }

    /**
     * Converts the deadline task to a file storage format.
     *
     * @return File-format string of the deadline task
     */
    @Override
    public String toFileString() {
        return "D | "
                + (isDone ? 1 : 0)
                + " | "
                + description
                + " | "
                + by;
    }
}
