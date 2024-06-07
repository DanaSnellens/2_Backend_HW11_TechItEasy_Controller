package nl.novi.backend_hw11_techiteasy.exceptions;

public class TelevisionNameTooLongException extends RuntimeException {

    public TelevisionNameTooLongException() {
        super();
    }
    public TelevisionNameTooLongException(String message) {
        super(message);
    }
}
