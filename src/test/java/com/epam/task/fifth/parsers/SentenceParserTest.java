package com.epam.task.fifth.parsers;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SentenceParserTest {
    private static final String TEXT = "Expression is [1 4 +]";

    private static final Component EXPECTED = new Composite(Arrays.asList(
            Lexeme.word("Expression"),
            Lexeme.word("is"),
            Lexeme.expression("[1 4 +]")
    )
    );

    @Test
    public void testParse() {
        SentenceParser parser = new SentenceParser(null);

        Component actual = parser.parse(TEXT);

        Assert.assertEquals(EXPECTED, actual);
    }
}
