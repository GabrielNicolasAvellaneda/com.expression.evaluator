package com.expression.evaluator;

public class UnaryExpression implements IExpression
{
	private int value;
	
	public UnaryExpression(String expression) {
		final int value = Integer.parseInt(expression);
		this.value = value;
	}
	
	public static Boolean IsUnaryExpression() {
		return false;
	}
	
	@Override
	public int evaluate() {
		// TODO Auto-generated method stub
		return this.value;
	}

}

