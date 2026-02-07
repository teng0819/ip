package misaka;

/**
 * Main entry point for the Misaka task management application.
 * Coordinates UI, storage, and command parsing.
 */
public class Misaka19090 {

    private final Ui ui;
    private final Storage storage;
    private TaskList tasks;

    /**
     * Constructs the application and loads tasks from the given file.
     *
     * @param filePath Path to the task storage file
     */
    public Misaka19090(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showError("Failed to load tasks.");
            tasks = new TaskList();
        }
    }

    /**
     * Runs the main program loop until the user exits.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String input = ui.readCommand();
                ui.showLine();

                String response = Parser.parse(input, tasks, storage);
                ui.showMessage(response);

                if (input.equals("bye")) {
                    isExit = true;
                }
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Starts the Misaka application
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        new Misaka19090("data/misaka.txt").run();
    }
}
