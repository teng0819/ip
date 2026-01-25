import java.util.Scanner;
class Task {
    String description;
    boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + description;
    }
}

class Todo extends Task {
    public Todo(String description) {
        super(description);
    }
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

class Deadline extends Task {
    String by;
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}

class Event extends Task {
    String from;
    String to;
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}

public class Misaka19090 {
    static void printError(String message) {
        System.out.println("____________________________________________________________");
        System.out.println(message);
        System.out.println("____________________________________________________________");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int taskCount = 0;

        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Misaka19090");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            }
            if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + "." + tasks[i]);
                }
                continue;
            }

            if (input.startsWith("mark ")) {
                int idx = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks[idx].mark();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(" " + tasks[idx]);
                continue;
            }

            if (input.startsWith("unmark ")) {
                int idx = Integer.parseInt(input.split(" ")[1]) - 1;
                tasks[idx].unmark();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(" " + tasks[idx]);
                continue;
            }

            try {
                if (input.equals("todo")) {
                    printError("Oops! The description of a todo cannot be empty.");
                    continue;
                }

                if (input.startsWith("todo ")) {
                    tasks[taskCount] = new Todo(input.substring(5));

                } else if (input.equals("deadline")) {
                    printError("Oops! The description of a deadline cannot be empty.");
                    continue;

                } else if (input.startsWith("deadline ")) {
                    String[] parts = input.substring(9).split(" /by ");
                    if (parts.length < 2) {
                        printError("Oops! Deadlines must have a /by date.");
                        continue;
                    }
                    tasks[taskCount] = new Deadline(parts[0], parts[1]);

                } else if (input.equals("event")) {
                    printError("Oops! The description of an event cannot be empty.");
                    continue;

                } else if (input.startsWith("event ")) {
                    String[] parts = input.substring(6).split(" /from | /to ");
                    if (parts.length < 3) {
                        printError("Oops! Events must have /from and /to.");
                        continue;
                    }
                    tasks[taskCount] = new Event(parts[0], parts[1], parts[2]);

                } else {
                    printError("Oops! I'm sorry, but I don't know what that means :-(");
                    continue;
                }

                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + tasks[taskCount].toString());
                taskCount++;
                System.out.println("Now you have " + taskCount + " tasks in the list.");
                System.out.println("____________________________________________________________");

            } catch (Exception e) {
                printError("Something went wrong. Please check your command format.");
            }

        }
    }
}
