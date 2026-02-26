package misaka;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Misaka19090 misaka = new Misaka19090("data/misaka.txt");

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
        AnchorPane root = fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Misaka19090");
        stage.show();

        // Inject logic into controller
        MainWindow controller = fxmlLoader.getController();
        controller.setMisaka(misaka);
    }

    public static void main(String[] args) {
        launch(args);
    }
}