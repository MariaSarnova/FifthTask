package com.epam.task.fifth.parsers;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;
import com.epam.task.fifth.entities.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class TextParserTest {
    private final String TEXT = "Hello my friends\n";
    private final Component PARAGRAPH = new Composite(Arrays.asList(
            Lexeme.word("Hello"),
            Lexeme.word("my"),
            Lexeme.word("friends")));

    private final Composite EXPECTED = new Composite();

    @Test
    public void testParseShouldReturnParagraphsWhenTextApplied(){

        EXPECTED.addComponent(PARAGRAPH);

        ParagraphParser nextParser = Mockito.mock(ParagraphParser.class);
        when(nextParser.getSuccessor()).thenReturn(nextParser);
        when(nextParser.parse(anyString())).thenReturn(PARAGRAPH);

        TextParser parser = new TextParser(nextParser);


        Component actual = parser.parse(TEXT);


        Assert.assertEquals(EXPECTED, actual);
    }

}
