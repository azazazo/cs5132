package Lab2.Q1;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String collection) {
        super("The target element is not in this " + collection);
    }
}
