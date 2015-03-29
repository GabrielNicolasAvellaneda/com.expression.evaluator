package com.expression.evaluator;

import org.junit.Test;
import org.junit.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest()
    {

    }
    
    @Test(expected = ExpressionParseException.class)
    public void Should_Throw_An_Exception_For_An_Empty_Expression() throws ExpressionParseException {
    	
    	final Expression exp = new Expression("");
    	
    	exp.evaluate();
    }

    @Test
    public void Should_Evaluate_A_Single_Number_Expression() throws ExpressionParseException {
    	
    	final Expression exp = new Expression("1");
    	
    	final int result = exp.evaluate();
    	
    	Assert.assertEquals(1, result);
    }
    
    
    
}
