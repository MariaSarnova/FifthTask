package com.epam.task.fifth.parsers;

public class ParsersBuilder {
    public AbstractParser build(){
        return new TextParser(new ParagraphParser(new SentenceParser(null)));
    }
}
