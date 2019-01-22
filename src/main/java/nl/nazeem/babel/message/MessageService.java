package nl.nazeem.babel.message;

import nl.nazeem.babel.messageresponse.MessageResponse;

import java.util.Optional;

public interface MessageService {

    Optional<MessageResponse> createResponse(String message);

}