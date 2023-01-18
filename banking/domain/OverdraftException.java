package banking.domain;

public class OverdraftException extends RuntimeException {
    private double deficit;

    public OverdraftException(String message,double deficit) {
        super(message);
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }

}
