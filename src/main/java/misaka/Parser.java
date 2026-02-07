package misaka;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Parses user input into executable commands or task objects.
 */
public class Parser {

    private static final String COMMAND_BYE = "bye";
    private static final String COMMAND_LIST = "list";

    private Parser() {
        // Prevent instantiation
    }

    /**
     * Parses user input and executes the corresponding command.
     *
     * @param input Full command entered by the user
     * @param tasks The task list to operate on
     * @param storage Storage handler for saving tasks
     * @return Response message to be shown to the user
     * @throws DukeException If the command format is invalid
     */
    public static String parse(String input, TaskList tasks, Storage storage)
            throws DukeException {

        if (input.equals(COMMAND_BYE)) {
            return "Bye. Hope to see you again soon!";
        }

        if (input.equals(COMMAND_LIST)) {
            return listTasks(tasks);
        }

        if (input.startsWith("todo ")) {
            Task task = new Todo(input.substring(5));
            tasks.add(task);
            storage.save(tasks);
            return "Got it. I've added this task:\n  " + task;
        }

        if (input.startsWith("deadline ")) {
            String[] parts = input.substring(9).split(" /by ");
            if (parts.length != 2) {
                throw new DukeException("Deadline format: deadline <task> /by <date>");
            }

            LocalDate date = LocalDate.parse(parts[1]);
            Task task = new Deadline(parts[0], date);
            tasks.add(task);
            storage.save(tasks);
            return "Got it. I've added this task:\n  " + task;
        }

        if (input.startsWith("event ")) {
            String[] parts = input.substring(6).split(" /from | /to ");
            if (parts.length != 3) {
                throw new DukeException("Event format: event <task> /from <start> /to <end>");
            }

            Task task = new Event(parts[0], parts[1], parts[2]);
            tasks.add(task);
            storage.save(tasks);
            return "Got it. I've added this task:\n  " + task;
        }

        if (input.startsWith("find ")) {
            String keyword = input.substring(5);
            return findTasks(tasks, keyword);
        }

        throw new DukeException("I don't understand this command.");
    }

    /**
     * Reconstructs a task object from a line stored in the data file.
     *
     * @param line A single line read from the task file
     * @return The reconstructed Task object
     * @throws DukeException If the task type is unknown
     */
    public static Task parseTaskFromFile(String line) throws DukeException {
        String[] parts = line.split(" \\| ");
        boolean isDone = parts[1].equals("1");

        switch (parts[0]) {
            case "T": {
                Task task = new Todo(parts[2]);
                task.setDone(isDone);
                return task;
            }
            case "D": {
                LocalDate date = LocalDate.parse(parts[3]);
                Task task = new Deadline(parts[2], date);
                task.setDone(isDone);
                return task;
            }
            case "E": {
                Task task = new Event(parts[2], parts[3], parts[4]);
                task.setDone(isDone);
                return task;
            }
            default:
                throw new DukeException("Unknown task type in file.");
        }
    }

    /**
     * Formats all tasks into a numbered list string.
     *
     * @param tasks Task list to display
     * @return Formatted task list string
     */
    private static String listTasks(TaskList tasks) {
        StringBuilder message = new StringBuilder("Here are the tasks in your list:\n");

        for (int i = 0; i < tasks.size(); i++) {
            message.append(i + 1)
                    .append(". ")
                    .append(tasks.get(i))
                    .append("\n");
        }

        return message.toString();
    }

    private static String findTasks(TaskList tasks, String keyword) {
        StringBuilder sb = new StringBuilder("Here are the matching tasks in your list:\n");

        ArrayList<Task> matches = tasks.find(keyword);

        for (int i = 0; i < matches.size(); i++) {
            sb.append(i + 1)
                    .append(".")
                    .append(matches.get(i))
                    .append("\n");
        }

        return sb.toString();
    }

}
