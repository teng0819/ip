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

public class DialogBox extends HBox {

    @FXML
    private Label dialog;

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
            // Misaka on left
            this.getChildren().add(0, displayPicture);
            this.setAlignment(Pos.TOP_LEFT);
        } else {
            // User on right
            this.getChildren().add(displayPicture); // picture at the end
            this.setAlignment(Pos.TOP_RIGHT);       // align entire HBox to right
        }

        this.setSpacing(10); // spacing between picture and text
    }

    public static DialogBox getUserDialog(String text, Image img) {
        return new DialogBox(text, img, false); // false = user
    }

    public static DialogBox getMisakaDialog(String text, Image img) {
        return new DialogBox(text, img, true);  // true = Misaka
    }
}