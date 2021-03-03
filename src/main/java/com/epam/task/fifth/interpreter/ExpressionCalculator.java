package com.epam.task.fifth.interpreter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionCalculator {
    private List<Interpreter> expressions = new ArrayList<>();
    private final String REGEX = "\\p{Blank}+";

    public Number calculate(String expression) {
        parse(expression);
        ArrayDeque<Double> stack = new ArrayDeque<>();

        for (Interpreter element : expressions) {
            element.interpret(stack);
        }

        return stack.pop();
    }

    private void parse(String expression) {
        String[] lexemes = expression.split(REGEX);

        for (String lexeme : lexemes) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    expressions.add(new TerminalExpressionPlus());
                    break;
                case '-':
                    expressions.add(new TerminalExpressionMinus());
                    break;
                case '*':
                    expressions.add(new TerminalExpressionMultiply());
                    break;
                case '/':
                    expressions.add(new TerminalExpressionDivide());
                    break;
                case '^':
                    expressions.add(new TerminalExpressionPower());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextDouble()) {
                        expressions.add(
                                new NonTerminalExpression(scan.nextDouble()));
                    }
            }
        }

    }
}
