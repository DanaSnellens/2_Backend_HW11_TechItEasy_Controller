package nl.novi.backend_hw11_techiteasy.exceptions;

public class InvalidNameException extends RuntimeException {

    public InvalidNameException() {
        super();
    }
    public InvalidNameException(String message) {
        super(message);
    }
}
