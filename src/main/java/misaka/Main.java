package misaka;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main GUI class for the Misaka task management application.
 * Handles the JavaFX user interface and user interactions.
 */

public class Main extends Application {

    private Misaka19090 misaka = new Misaka19090("data/misaka.txt");

    private TextArea dialogBox;
    private TextField userInput;

    @Override
    public void start(Stage stage) {

        dialogBox = new TextArea();
        dialogBox.setEditable(false);
        dialogBox.setWrapText(true);

        userInput = new TextField();
        Button sendButton = new Button("Send");

        sendButton.setOnAction(e -> handleUserInput());
        userInput.setOnAction(e -> handleUserInput());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        layout.getChildren().addAll(dialogBox, userInput, sendButton);

        Scene scene = new Scene(layout, 500, 400);

        stage.setTitle("Misaka19090");
        stage.setScene(scene);
        stage.show();

        dialogBox.appendText("Hello! I'm Misaka19090\n");
        dialogBox.appendText("What can I do for you?\n\n");
    }

    private void handleUserInput() {
        String input = userInput.getText();

        dialogBox.appendText("You: " + input + "\n");

        String response = misaka.getResponse(input);

        dialogBox.appendText("Misaka: " + response + "\n\n");

        userInput.clear();
    }
}
