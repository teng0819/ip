import java.io.*;
import java.util.ArrayList;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

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

    public void save(TaskList tasks) throws DukeException {
        try (FileWriter fw = new FileWriter(filePath)) {
            for (Task task : tasks.getTasks()) {
                fw.write(task.toFileString() + "\n");
            }
        } catch (IOException e) {
            throw new DukeException("Error saving file.");
        }
    }
}
