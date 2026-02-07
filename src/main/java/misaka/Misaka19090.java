package misaka;

public class Misaka19090 {

    private final Ui ui;
    private final Storage storage;
    private TaskList tasks;

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

    public static void main(String[] args) {
        new Misaka19090("data/misaka.txt").run();
    }
}
