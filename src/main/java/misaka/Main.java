package misaka;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Launches the Misaka19090 chatbot application.
 *
 * <p>This class serves as the entry point of the JavaFX application.
 * It is responsible for:
 * <ul>
 *     <li>Initialising the chatbot backend.</li>
 *     <li>Loading the main FXML layout.</li>
 *     <li>Setting up the primary stage and scene.</li>
 *     <li>Injecting the chatbot instance into the UI controller.</li>
 * </ul>
 *
 * <p>The application follows a separation of concerns design:
 * the {@code Main} class handles application bootstrapping,
 * while {@code MainWindow} manages user interaction and UI logic.
 */
public class Main extends Application {

    private Misaka19090 misaka = new Misaka19090("data/misaka.txt");

    /**
     * Starts the JavaFX application.
     *
     * <p>This method loads the {@code MainWindow.fxml} layout,
     * creates the primary scene, and associates the chatbot instance
     * with the UI controller.</p>
     *
     * @param stage The primary stage provided by the JavaFX runtime.
     * @throws Exception If the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
        AnchorPane root = fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Misaka19090");
        stage.show();

        MainWindow controller = fxmlLoader.getController();
        controller.setMisaka(misaka);
    }

    /**
     * Main method that launches the JavaFX application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}