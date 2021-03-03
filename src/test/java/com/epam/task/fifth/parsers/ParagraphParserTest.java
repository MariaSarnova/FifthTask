package com.epam.task.fifth.parsers;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import static org.mockito.Mockito.when;

public class ParagraphParserTest {
    private static final String TEXT = "Hello my friends. My expression is [3 4 +].";
    private static final String TEXT_FIRST_SENTENCE="Hello my friends";
    private static final String TEXT_SECOND_SENTENCE="My expression is [3 4 +]";
    private static final Component FIRST_SENTENCE = new Composite(Arrays.asList(
            Lexeme.word("Hello"),
            Lexeme.word("my"),
            Lexeme.word("friends")
    ));

    private static final Component SECOND_SENTENCE = new Composite(Arrays.asList(
            Lexeme.word("My"),
            Lexeme.word("expression"),
            Lexeme.word("is"),
            Lexeme.expression("[3 4 +]")
    ));

    private static final Component EXPECTED = new Composite(Arrays.asList(
            FIRST_SENTENCE, SECOND_SENTENCE
    ));

    @Test
    public void testParse() {
        SentenceParser sentenceParser = Mockito.mock(SentenceParser.class);
        when(sentenceParser.parse(TEXT_FIRST_SENTENCE)).thenReturn(FIRST_SENTENCE);
        when(sentenceParser.parse(TEXT_SECOND_SENTENCE)).thenReturn(SECOND_SENTENCE);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);

        Component actual = paragraphParser.parse(TEXT);

        Assert.assertEquals(EXPECTED, actual);
    }
}
