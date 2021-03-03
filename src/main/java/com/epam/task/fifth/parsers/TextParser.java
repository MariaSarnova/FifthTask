package com.epam.task.fifth.parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser extends AbstractParser{
    private final static Logger LOGGER = LogManager.getLogger(TextParser.class);
    public TextParser(AbstractParser successor){
        super(successor);
    }

    @Override
    protected String getSplitter(){
        LOGGER.info("Parsed by TextParser");
        return "\n";
    }
}
