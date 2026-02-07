package misaka;

import java.util.Scanner;

/**
 * Handles all interactions with the user, including input and output.
 */
public class Ui {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Displays theh welcome message when the application starts.
     */
    public void showWelcome() {
        showLine();
        System.out.println("Hello! I'm Misaka19090");
        System.out.println("What can I do for you?");
        showLine();
    }

    /**
     * Reads a command from the user.
     *
     * @return User input string
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays a normal message to the user.
     *
     * @param message Message to be displayed
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays an error message to the user.
     *
     * @param message Error message
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Prints a horizontal divider line.
     */
    public void showLine() {
        System.out.println("____________________________________________________________");
    }
}
