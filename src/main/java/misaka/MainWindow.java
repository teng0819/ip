package misaka;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class MainWindow {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox dialogContainer;

    @FXML
    private TextField userInput;

    private Misaka19090 misaka;

    // Load profile images from resources
    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/user.png"));
    private Image misakaImage = new Image(this.getClass().getResourceAsStream("/images/misaka.png"));

    @FXML
    public void initialize() {
        // Auto scroll to bottom when new dialog is added
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());

        // Send message on pressing Enter
        userInput.setOnAction(event -> handleUserInput());
    }

    /**
     * Sets the Misaka chatbot instance and displays the initial greeting messages.
     */
    public void setMisaka(Misaka19090 misaka) {
        this.misaka = misaka;

        // Add initial messages from Misaka with left-aligned profile picture
        dialogContainer.getChildren().add(
                DialogBox.getMisakaDialog("Hello! I'm Misaka19090", misakaImage)
        );
        dialogContainer.getChildren().add(
                DialogBox.getMisakaDialog("What can I do for you?", misakaImage)
        );
    }

    /**
     * Handles user input from the text field and displays dialog boxes for both user and Misaka.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();

        if (input.isBlank()) {
            return; // ignore empty input
        }

        // Create DialogBox for the user (right-aligned)
        DialogBox userDialog = DialogBox.getUserDialog(input, userImage);

        // Create DialogBox for Misaka response (left-aligned)
        DialogBox misakaDialog = DialogBox.getMisakaDialog(misaka.getResponse(input), misakaImage);

        // Add both dialog boxes to the container
        dialogContainer.getChildren().addAll(userDialog, misakaDialog);

        // Clear input field
        userInput.clear();
    }
}