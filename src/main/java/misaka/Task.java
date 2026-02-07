package misaka;

/**
 * Represents a generic task with a description and completion status.
 * All specific task types inherit from this class.
 */

public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a task with the given description
     *
     * @param description Description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as completed.
     */
    public void mark() {
        isDone = true;
    }

    /**
     * Marks the task as not completed.
     */
    public void unmark() {
        isDone = false;
    }

    /**
     * Returns the status icon of the task.
     *
     * @return "X" if done, otherwise a blank space
     */
    protected String statusIcon() {
        return isDone ? "X" : " ";
    }

    /**
     * Converts the task into a string suitable for file storage
     *
     * @return File-format string of the task
     */
    public abstract String toFileString();
}
