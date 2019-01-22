package nl.nazeem.babel.server.message;

import nl.nazeem.babel.server.messageresponse.MessageResponseType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "message")
public class MessageConfigurationProperties {

    private MessageResponseType messageResponseType;

    public MessageResponseType getMessageResponseType() {
        return messageResponseType;
    }

    public void setMessageResponseType(MessageResponseType messageResponseType) {
        this.messageResponseType = messageResponseType;
    }
}
