package misaka;

/**
 * Represents a task without a specific date or time.
 */
public class Todo extends Task {

    /**
     * Creates a todo task with the given description.
     *
     * @param description Description of the task
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns the string representation of the todo task.
     *
     * @return Formatted todo task string
     */
    @Override
    public String toString() {
        return "[T][" + statusIcon() + "] " + description;
    }

    /**
     * Converts the todo task to a file storage format.
     *
     * @return File-format string of the todo task
     */
    @Override
    public String toFileString() {
        return "T | " + (isDone ? 1 : 0) + " | " + description;
    }
}
