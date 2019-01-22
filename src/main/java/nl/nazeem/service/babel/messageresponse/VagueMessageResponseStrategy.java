package nl.nazeem.service.babel.messageresponse;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VagueMessageResponseStrategy implements MessageResponseStrategy {

    private final static List<String> VAGUE_SENTENCES = Arrays.asList(
            "Sorry, I don't understand you.",
            "Could you repeat that please?",
            "I'm confused..",
            "Well.. ehh.. uhh.. okayy I guess?"
    );

    @Override
    public String getResponse(String message) {
        if(StringUtils.isBlank(message)) {
            return StringUtils.EMPTY;
        }

        int index = ThreadLocalRandom.current().nextInt(VAGUE_SENTENCES.size());

        return VAGUE_SENTENCES.get(index);
    }
}
