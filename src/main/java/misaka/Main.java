package misaka;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Misaka19090 misaka = new Misaka19090("data/misaka.txt");

    private TextArea dialogBox;
    private TextField userInput;
    private Ui ui;

    @Override
    public void start(Stage stage) {
        // TextArea for conversation
        dialogBox = new TextArea();
        dialogBox.setEditable(false);
        dialogBox.setWrapText(true);

        // TextField for user input
        userInput = new TextField();
        userInput.setPromptText("Enter command here");

        // Button to send message
        Button sendButton = new Button("Send");

        // Initialize Ui
        ui = new Ui();

        // Actions
        sendButton.setOnAction(e -> handleUserInput());
        userInput.setOnAction(e -> handleUserInput());

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(dialogBox, userInput, sendButton);

        Scene scene = new Scene(layout, 500, 400);
        stage.setTitle("Misaka19090");
        stage.setScene(scene);
        stage.show();

        // Initial messages
        ui.showMessage("Hello! I'm Misaka19090");
        ui.showMessage("What can I do for you?");
        dialogBox.setText(ui.getDialog());
    }

    private void handleUserInput() {
        String input = userInput.getText();

        // Show user's input in the dialog
        dialogBox.appendText("You: " + input + "\n");

        // Get response (no try/catch needed)
        String response = misaka.getResponse(input);
        dialogBox.appendText("Misaka: " + response + "\n\n");

        userInput.clear();
    }

    public static void main(String[] args) {
        launch();
    }
}