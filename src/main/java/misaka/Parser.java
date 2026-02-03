package misaka;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parser {

    public static String parse(String input, TaskList tasks, Storage storage)
            throws DukeException {

        if (input.equals("bye")) {
            return "Bye. Hope to see you again soon!";
        }

        if (input.equals("list")) {
            return listTasks(tasks);
        }

        if (input.startsWith("todo ")) {
            Task t = new Todo(input.substring(5));
            tasks.add(t);
            storage.save(tasks);
            return "Got it. I've added this task:\n  " + t;
        }

        if (input.startsWith("deadline ")) {
            String[] parts = input.substring(9).split(" /by ");
            LocalDate date = LocalDate.parse(parts[1]);
            Task t = new Deadline(parts[0], date);
            tasks.add(t);
            storage.save(tasks);
            return "Got it. I've added this task:\n  " + t;
        }

        if (input.startsWith("event ")) {
            String[] parts = input.substring(6).split(" /from | /to ");
            Task t = new Event(parts[0], parts[1], parts[2]);
            tasks.add(t);
            storage.save(tasks);
            return "Got it. I've added this task:\n  " + t;
        }

        throw new DukeException("I don't understand this command.");
    }

    public static Task parseTaskFromFile(String line) {
        String[] parts = line.split(" \\| ");
        boolean done = parts[1].equals("1");

        if (parts[0].equals("T")) {
            Task t = new Todo(parts[2]);
            t.setDone(done);
            return t;
        }

        if (parts[0].equals("D")) {
            LocalDate date = LocalDate.parse(parts[3]);
            Task t = new Deadline(parts[2], date);
            t.setDone(done);
            return t;
        }

        if (parts[0].equals("E")) {
            Task t = new Event(parts[2], parts[3], parts[4]);
            t.setDone(done);
            return t;
        }

        return null;
    }

    private static String listTasks(TaskList tasks) {
        StringBuilder sb = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(i + 1).append(".").append(tasks.get(i)).append("\n");
        }
        return sb.toString();
    }
}
