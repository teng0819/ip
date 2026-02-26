package misaka;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

/**
 * Controller for the main chat window.
 * Handles user input and dialog rendering.
 */
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

    /**
     * Initialises UI components after FXML loading.
     *
     * <p>This method:
     * <ul>
     *     <li>Binds the scroll pane to automatically scroll
     *     when new dialog messages are added.</li>
     *     <li>Registers an event handler for the Enter key
     *     in the user input field.</li>
     * </ul>
     * </p>
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        userInput.setOnAction(event -> handleUserInput());
    }

    /**
     * Injects the chatbot backend and displays initial greeting messages.
     *
     * @param misaka The chatbot instance to be used for processing input.
     */
    public void setMisaka(Misaka19090 misaka) {
        this.misaka = misaka;

        dialogContainer.getChildren().add(
                DialogBox.getMisakaDialog("Hello! I'm Misaka19090", misakaImage)
        );
        dialogContainer.getChildren().add(
                DialogBox.getMisakaDialog("What can I do for you?", misakaImage)
        );
    }

    /**
     * Processes user input and updates the dialog display.
     *
     * <p>This method:
     * <ul>
     *     <li>Retrieves text from the input field.</li>
     *     <li>Ignores blank input.</li>
     *     <li>Generates a chatbot response via {@code Misaka19090}.</li>
     *     <li>Displays both user and chatbot messages.</li>
     *     <li>Clears the input field.</li>
     * </ul>
     * </p>
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();

        if (input.isBlank()) {
            return;
        }

        DialogBox userDialog = DialogBox.getUserDialog(input, userImage);
        DialogBox misakaDialog = DialogBox.getMisakaDialog(misaka.getResponse(input), misakaImage);

        dialogContainer.getChildren().addAll(userDialog, misakaDialog);
        userInput.clear();
    }
}