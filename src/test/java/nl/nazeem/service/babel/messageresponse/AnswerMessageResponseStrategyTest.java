package nl.nazeem.service.babel.messageresponse;

import org.junit.Test;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class AnswerMessageResponseStrategyTest {

    private MessageResponseStrategy strategy = new AnswerMessageResponseStrategy();

    @Test
    public void getResponse_nullInput_returnBlankString() {
        assertThat(strategy.getResponse(null), isEmptyString());
    }

    @Test
    public void getResponse_emptyInput_returnBlankString() {
        assertThat(strategy.getResponse(""), isEmptyString());
    }

    @Test
    public void getResponse_emptyInput_returnNonBlankString() {
        assertThat(strategy.getResponse("Hi! I'm Nazeem"), not(isEmptyString()));
    }
}