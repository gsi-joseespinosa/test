package starter.comun;

public class ErrorFailure extends AssertionError {
    public ErrorFailure(String message, Throwable cause){
        super(message,cause);
    }
}
