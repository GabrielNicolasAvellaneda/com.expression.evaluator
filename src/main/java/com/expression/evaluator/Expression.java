package com.expression.evaluator;

public class Expression {
	
	private String expression = ""; 
	
	public Expression(String expression) throws ExpressionParseException {
	
		setExpression(expression);
	}
	
	public String getExpression() {
		return expression;
	}
	
	public void setExpression(String expression) throws ExpressionParseException {
		
		if (expression == null || expression.trim().isEmpty()) {
			throw new ExpressionParseException();
		}
		
		this.expression = expression.trim();
	}
	
	public int evaluate() throws ExpressionParseException {
		
		try {
			
			final int index = expression.indexOf("+");
			if (index != -1) {
				final String leftOperandString = Expression.substring(0, index-1, expression).trim();
				final String rightOperandString = Expression.substring(index+1, expression).trim();
				
				final int a = Integer.parseInt(leftOperandString);
				final int b = Integer.parseInt(rightOperandString);
				
				return a + b;
			}
			
			final int result = Integer.parseInt(expression);
			return result;
		}
		catch(NumberFormatException ex) {
			throw new ExpressionParseException(ex);
		}
		
	}
	
	public static char chartAt(int index, String expression) {
		
		return expression.charAt(index);
	}
	
	public static String substring(int beginIndex, int endIndex, String expression) {
		
		return expression.substring(beginIndex, endIndex);
	}
	
	public static String substring(int beginIndex, String expression) {
		return expression.substring(beginIndex);
	}
	
}
