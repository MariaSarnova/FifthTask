package com.epam.task.fifth.parsers;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Lexeme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser{
    private static final String WORD_PATTERN = "(\\S+)";
    private static final String EXPRESSION_PATTERN = "(\\[.*])";
    private final static Logger LOGGER = LogManager.getLogger(SentenceParser.class);

    private static final String ANY = EXPRESSION_PATTERN + "|"  + WORD_PATTERN;
    private static final Pattern PATTERN = Pattern.compile(ANY);

    public SentenceParser(AbstractParser successor) {
        super(successor);
    }

    protected String getSplitter() {
        return "";
    }

    @Override
    public Component parse(String input) {
        LOGGER.info("Parsed by SentenceParser");
        Matcher matcher = PATTERN.matcher(input);
        Composite composite = new Composite();
        List<String> lexemes = new ArrayList<>();

        while (matcher.find()){
            lexemes.add(matcher.group());
        }

        lexemes.stream()
                .forEach(lexeme -> {
            if (lexeme.matches(EXPRESSION_PATTERN)) {
                composite.addComponent(Lexeme.expression(lexeme));
            } else {
                composite.addComponent(Lexeme.word(lexeme));
            }
        });
        return composite;
    }
}
