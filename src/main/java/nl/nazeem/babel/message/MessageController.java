package nl.nazeem.babel.message;

import nl.nazeem.babel.messageresponse.MessageResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value = "/message/{message}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MessageResponse getMessage(@PathVariable String message) throws EmptyMessageException {
        return messageService.createResponse(message).orElseThrow(EmptyMessageException::new);
    }
}
