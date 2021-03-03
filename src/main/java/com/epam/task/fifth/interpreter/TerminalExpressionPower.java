package com.epam.task.fifth.interpreter;

import java.util.ArrayDeque;

public class TerminalExpressionPower implements Interpreter{
    @Override
    public void interpret(ArrayDeque<Double> stack) {
        double value=stack.pop();
        double power=stack.pop();
        stack.push(Math.pow(value,power));
    }
}
