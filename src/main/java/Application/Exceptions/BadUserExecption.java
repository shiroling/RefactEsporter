package Application.Exceptions;

public class BadUserExecption extends Exception {
    public BadUserExecption(String errorMessage) {
        super(errorMessage);
    }
}