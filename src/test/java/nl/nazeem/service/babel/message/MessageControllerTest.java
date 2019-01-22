package nl.nazeem.service.babel.message;

import nl.nazeem.service.babel.messageresponse.MessageResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MessageController.class)
@EnableConfigurationProperties
public class MessageControllerTest {

    @MockBean
    private MessageService messageService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getMessage_blankMessage_return400BadRequest() throws Exception {
        when(messageService.createResponse(anyString())).thenReturn(Optional.empty());

        mockMvc.perform(get("/message/ ").contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(status().is(400));
    }

    @Test
    public void getMessage_message_return200Ok() throws Exception {
        when(messageService.createResponse(eq("Hi, I'am Nazeem!"))).thenReturn(Optional.of(new MessageResponse("Hi, I'am Nazeem!")));

        mockMvc.perform(get("/message/Hi, I'am Nazeem!").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is(200));
    }
}