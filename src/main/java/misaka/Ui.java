package misaka;

/**
 * Handles interactions with the user.
 */
public class Ui {

    private final StringBuilder dialog = new StringBuilder();

    /**
     * Appends a normal message.
     */
    public void showMessage(String message) {
        dialog.append(message).append("\n");
    }

    /**
     * Appends an error message.
     */
    public void showError(String message) {
        dialog.append("[ERROR] ").append(message).append("\n");
    }

    /**
     * Returns all messages so far (for showing in TextArea)
     */
    public String getDialog() {
        return dialog.toString();
    }
}