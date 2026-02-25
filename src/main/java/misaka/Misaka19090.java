package misaka;

/**
 * Main logic class for the Misaka task management application.
 * Handles storage, tasks, and parsing commands.
 */
public class Misaka19090 {

    private final Storage storage;
    private TaskList tasks;

    /**
     * Constructs the application and loads tasks from the given file.
     *
     * @param filePath Path to the task storage file
     */
    public Misaka19090(String filePath) {
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            // If loading fails, start with an empty TaskList
            tasks = new TaskList();
        }
    }

    /**
     * Processes user input and returns chatbot response (for GUI).
     *
     * @param input User input string
     * @return Response string
     */
    public String getResponse(String input) {
        try {
            // Parse the input and update tasks/storage
            return Parser.parse(input, tasks, storage);
        } catch (DukeException e) {
            // Return error message prefixed with [ERROR] for GUI display
            return "[ERROR] " + e.getMessage();
        }
    }

}