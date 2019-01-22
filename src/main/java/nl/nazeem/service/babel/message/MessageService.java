package nl.nazeem.service.babel.message;

import nl.nazeem.service.babel.messageresponse.MessageResponse;

import java.util.Optional;

public interface MessageService {

    Optional<MessageResponse> createResponse(String message);

}