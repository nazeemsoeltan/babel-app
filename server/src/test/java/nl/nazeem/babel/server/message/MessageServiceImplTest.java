package nl.nazeem.babel.server.message;

import nl.nazeem.babel.server.messageresponse.AnswerMessageResponseStrategy;
import nl.nazeem.babel.server.messageresponse.MessageResponse;
import nl.nazeem.babel.server.messageresponse.MessageResponseStrategy;
import nl.nazeem.babel.server.messageresponse.MessageResponseType;
import nl.nazeem.babel.server.messageresponse.VagueMessageResponseStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@EnableConfigurationProperties
public class MessageServiceImplTest {

    @Mock
    private MessageConfigurationProperties properties;

    @Mock
    private Map<MessageResponseType, MessageResponseStrategy> strategyMap;

    @InjectMocks
    private MessageServiceImpl messageService;

    @Test
    public void getMessage_messageResponseTypeIsNull_noMessageResponse() {
        when(properties.getMessageResponseType()).thenReturn(null);

        Optional<MessageResponse> response = messageService.createResponse("Hi!");

        assertFalse(response.isPresent());
    }

    @Test
    public void getMessage_messageResponseTypeIsAnswer_returnMessageResponse() {
        when(properties.getMessageResponseType()).thenReturn(MessageResponseType.ANSWER);
        when(strategyMap.get(eq(MessageResponseType.ANSWER))).thenReturn(new AnswerMessageResponseStrategy());

        Optional<MessageResponse> response = messageService.createResponse("Hi!");

        assertTrue(response.isPresent());
    }

    @Test
    public void getMessage_messageResponseTypeIsVague_returnMessageResponse() {
        when(properties.getMessageResponseType()).thenReturn(MessageResponseType.VAGUE);
        when(strategyMap.get(eq(MessageResponseType.VAGUE))).thenReturn(new VagueMessageResponseStrategy());

        Optional<MessageResponse> response = messageService.createResponse("Hi!");

        assertTrue(response.isPresent());
    }
}