package misaka;

import java.util.ArrayList;

/**
 * Represents a list of tasks and provides operations on them.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Creates an empty task list.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Creates a task list with existing tasks.
     *
     * @param tasks Existing list of tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the list.
     *
     * @param task Task to be added
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Returns a task at the specified index.
     *
     * @param index Index of the task
     * @return Task at the index
     */
    public Task get(int index) {
        assert index >= 0 : "Index must be non-negative";
        assert index < tasks.size() : "Index out of range";
        return tasks.get(index);
    }

    /**
     * Removes a task from the list.
     *
     * @param index Index of the task
     * @return Removed task
     */
    public Task remove(int index) {
        assert index >= 0 && index < tasks.size() : "Index invalid for removal";
        return tasks.remove(index);
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return Number of tasks
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Returns the tasks in the list
     *
     * @return tasks in the list
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * find whether a keyword exists in the task
     *
     * @param keyword the word we want to find
     * @return the result found in the task
     */
    public ArrayList<Task> find(String keyword) {
        assert keyword != null : "Keyword must not be null";
        assert !keyword.isEmpty() : "User input must not be empty";
        ArrayList<Task> result = new ArrayList<>();

        for (Task task : tasks) {
            if (task.description.contains(keyword)) {
                result.add(task);
            }
        }

        return result;
    }

}
