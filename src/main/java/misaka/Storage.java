package misaka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles loading tasks from and saving tasks to a file
 */

public class Storage {
    private final String filePath;

    /**
     * Creates a Storage object using the given file path.
     *
     * @param filePath Path to the file used for storage
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the storage file.
     *
     * @return List of tasks loaded from the file
     * @throws DukeException If an error occurs while reading the file
     */
    public ArrayList<Task> load() throws DukeException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return tasks;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                tasks.add(Parser.parseTaskFromFile(line));
            }
        } catch (IOException e) {
            throw new DukeException("Error loading file.");
        }
        return tasks;
    }

    /**
     * Saves all tasks to the storage file.
     *
     * @param tasks Task list to be saved
     * @throws DukeException If an error occurs while writing to the file
     */
    public void save(TaskList tasks) throws DukeException {
        File file = new File(filePath);

        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (FileWriter fw = new FileWriter(file)) {
            for (Task task : tasks.getTasks()) {
                fw.write(task.toFileString() + "\n");
            }
        } catch (IOException e) {
            throw new DukeException("Error saving file.");
        }
    }
}
