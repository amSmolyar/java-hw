package AccessCheck;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String exceptionText) {
        super(exceptionText);
    }
}
