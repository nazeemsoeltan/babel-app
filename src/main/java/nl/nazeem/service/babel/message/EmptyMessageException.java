package nl.nazeem.service.babel.message;

public class EmptyMessageException extends Exception {

    public EmptyMessageException() {
        super("Hey! What are you trying to say?");
    }
}
