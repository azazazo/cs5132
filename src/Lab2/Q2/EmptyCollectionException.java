package Lab2.Q2;

public class EmptyCollectionException extends RuntimeException {
    public EmptyCollectionException(String collection) {
        super("The " + collection + " is empty.");
    }
}
