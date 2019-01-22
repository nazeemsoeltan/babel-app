package nl.nazeem.service.babel.messageresponse;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AnswerMessageResponseStrategy implements MessageResponseStrategy {

    private final static List<String> ANSWER_SENTENCES = Arrays.asList(
            "Hahahah, you make me laugh.",
            "Ehmm... I'll just be quiet.",
            "Oh really?"
    );

    @Override
    public String getResponse(String message) {
        if(StringUtils.isBlank(message)) {
            return StringUtils.EMPTY;
        }

        int index = ThreadLocalRandom.current().nextInt(ANSWER_SENTENCES.size());

        return ANSWER_SENTENCES.get(index);
    }
}
