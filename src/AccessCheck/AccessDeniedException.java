package AccessCheck;

public class AccessDeniedException extends Exception {
    public AccessDeniedException(String exceptionText) {
        super(exceptionText);
    }
}
