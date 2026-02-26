package misaka;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * Represents a single dialog message in the chat UI.
 */
public class DialogBox extends HBox {

    @FXML
    private Label dialog;

    /**
     * Constructs a dialog box with specified text, image,
     * and alignment configuration.
     *
     * @param text      The message content to display.
     * @param img       The profile image associated with the speaker.
     * @param isMisaka  Indicates whether the dialog belongs to the chatbot.
     *                  If true, the message is left-aligned;
     *                  otherwise, it is right-aligned.
     */
    private DialogBox(String text, Image img, boolean isMisaka) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    getClass().getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            HBox root = fxmlLoader.load();
            this.getChildren().addAll(root.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);

        ImageView displayPicture = new ImageView(img);
        displayPicture.setFitWidth(50);
        displayPicture.setFitHeight(50);

        if (isMisaka) {
            this.getChildren().add(0, displayPicture);
            this.setAlignment(Pos.TOP_LEFT);
        } else {
            this.getChildren().add(displayPicture);
            this.setAlignment(Pos.TOP_RIGHT);
        }

        this.setSpacing(10);
    }

    /**
     * Creates a dialog box representing a user message.
     *
     * @param text The message content.
     * @param img  The user's profile image.
     * @return A right-aligned dialog box instance.
     */
    public static DialogBox getUserDialog(String text, Image img) {
        return new DialogBox(text, img, false);
    }

    /**
     * Creates a dialog box representing a chatbot message.
     *
     * @param text The message content.
     * @param img  The chatbot's profile image.
     * @return A left-aligned dialog box instance.
     */
    public static DialogBox getMisakaDialog(String text, Image img) {
        return new DialogBox(text, img, true);
    }
}