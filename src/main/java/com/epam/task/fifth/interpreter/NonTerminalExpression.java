package com.epam.task.fifth.interpreter;

import java.util.ArrayDeque;

public class NonTerminalExpression implements Interpreter{
    private double number;

    public NonTerminalExpression(double number) {
        this.number = number;
    }

    @Override
    public void interpret(ArrayDeque<Double> stack) {
        stack.push(number);
    }
}
