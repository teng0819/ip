package misaka;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private LocalDate by;

    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    public String toString() {
        return "[D][" + statusIcon() + "] " + description +
                " (by: " + by.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }

    public String toFileString() {
        return "D | " + (isDone ? 1 : 0) + " | " + description + " | " + by;
    }
}
