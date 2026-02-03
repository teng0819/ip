package misaka;

import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);

    public void showWelcome() {
        showLine();
        System.out.println("Hello! I'm Misaka19090");
        System.out.println("What can I do for you?");
        showLine();
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showLine() {
        System.out.println("____________________________________________________________");
    }
}
