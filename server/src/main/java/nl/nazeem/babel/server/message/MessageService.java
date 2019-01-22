package nl.nazeem.babel.server.message;

import nl.nazeem.babel.server.messageresponse.MessageResponse;

import java.util.Optional;

public interface MessageService {

    Optional<MessageResponse> createResponse(String message);

}