package misaka;

/**
 * Represents an exception specific to the Duke application.
 */
public class DukeException extends Exception {

    /**
     * Creates a DukeException with the specified error message
     *
     * @param message Description of the error
     */
    public DukeException(String message) {
        super(message);
    }
}

