package nl.nazeem.service.babel.message;

import nl.nazeem.service.babel.messageresponse.MessageResponse;
import nl.nazeem.service.babel.messageresponse.MessageResponseStrategy;
import nl.nazeem.service.babel.messageresponse.MessageResponseType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class MessageServiceImpl implements MessageService {

    private final MessageConfigurationProperties messageConfigurationProperties;
    private final Map<MessageResponseType, MessageResponseStrategy> responseStrategies;

    public MessageServiceImpl(MessageConfigurationProperties messageConfigurationProperties,
                              Map<MessageResponseType, MessageResponseStrategy> responseStrategies) {
        this.messageConfigurationProperties = messageConfigurationProperties;
        this.responseStrategies = responseStrategies;
    }

    @Override
    public Optional<MessageResponse> createResponse(String message) {
        MessageResponseStrategy strategy = responseStrategies.get(messageConfigurationProperties.getMessageResponseType());

        if(strategy == null) {
            return Optional.empty();
        }

        String response = strategy.getResponse(message);

        return StringUtils.isEmpty(response) ? Optional.empty() : Optional.of(new MessageResponse(response));
    }
}
