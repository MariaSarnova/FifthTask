package com.epam.task.fifth.parsers;

import com.epam.task.fifth.entities.Component;
import com.epam.task.fifth.entities.Composite;

import java.util.Arrays;

public abstract class AbstractParser{
    private AbstractParser successor;

    public AbstractParser(AbstractParser successor){
        this.successor=successor;
    }

    protected AbstractParser getSuccessor(){
        return successor;
    }

    protected abstract String getSplitter();


    public Component parse(String input) {
        String splitter=getSplitter();
        Composite composite=new Composite();
        AbstractParser successor=getSuccessor();
        Arrays.stream(input.split(splitter)).forEach(part->composite.addComponent(successor.parse(part)));
        return composite;
    }
}
