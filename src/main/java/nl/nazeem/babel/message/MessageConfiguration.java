package nl.nazeem.babel.message;

import nl.nazeem.babel.messageresponse.AnswerMessageResponseStrategy;
import nl.nazeem.babel.messageresponse.MessageResponseStrategy;
import nl.nazeem.babel.messageresponse.MessageResponseType;
import nl.nazeem.babel.messageresponse.VagueMessageResponseStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MessageConfiguration {

    @Bean
    public Map<MessageResponseType, MessageResponseStrategy> responseStrategies() {
        Map<MessageResponseType, MessageResponseStrategy> responseStrategies = new HashMap<>();
        responseStrategies.put(MessageResponseType.ANSWER, new AnswerMessageResponseStrategy());
        responseStrategies.put(MessageResponseType.VAGUE, new VagueMessageResponseStrategy());

        return responseStrategies;
    }
}
