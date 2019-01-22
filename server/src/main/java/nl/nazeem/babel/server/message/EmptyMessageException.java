package nl.nazeem.babel.server.message;

public class EmptyMessageException extends Exception {

    public EmptyMessageException() {
        super("Hey! What are you trying to say?");
    }
}
