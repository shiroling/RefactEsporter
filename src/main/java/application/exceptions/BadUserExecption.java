package application.exceptions;

public class BadUserExecption extends Exception {
    public BadUserExecption(String errorMessage) {
        super(errorMessage);
    }
}