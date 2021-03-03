package com.epam.task.fifth.parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser extends AbstractParser{
    private final static Logger LOGGER = LogManager.getLogger(ParagraphParser.class);

    public ParagraphParser(AbstractParser successor){
        super(successor);
    }

    @Override
    protected String getSplitter() {
        LOGGER.info("Parsed by ParagraphsParser");
        return "\\. ?";
    }
}
