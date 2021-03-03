package com.epam.task.fifth.interpreter;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionCalculatorTest {
    private final String EXPRESSION = "8 2 10 70 2 10 ^ - + * /";
    private final double EXPECTED = 10;
    private final double DELTA = 0.001;

    @Test
    public void testCalculateShouldReturnExpressionResultWhenExpressionStringApplied(){
        ExpressionCalculator calculator = new ExpressionCalculator();

        double actual = (double) calculator.calculate(EXPRESSION);

        Assert.assertEquals(EXPECTED, actual, DELTA);
    }
}
