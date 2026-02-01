public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    protected String statusIcon() {
        return isDone ? "X" : " ";
    }

    public abstract String toFileString();
}
