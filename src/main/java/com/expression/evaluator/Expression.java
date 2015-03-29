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
	
	public class BinaryOperatorInfo {
		
		char operator = '\0';
		int index = -1;
		
		public BinaryOperatorInfo(char operator, int index) {
			this.operator = operator;
			this.index = index;
		}
		
		public int getIndex() {
			return index;
		}
		
		public char getOperator() {
			return operator;
		}
	}
	
	
	public BinaryOperatorInfo getBinaryOperatorInfo(String expression) {
		
		char sumOperator = '+';
		char diffOperator = '-';
		
		int index = expression.indexOf(sumOperator); 
		if (index != -1) {
			return new BinaryOperatorInfo(sumOperator, index);
			
		} 
		else 
		{
			 index = expression.indexOf(diffOperator);
			 if (index != -1) {
				 return new BinaryOperatorInfo(diffOperator, index);
			 }
			
		}
		return null;
	}
	
	
	public int evaluate() throws ExpressionParseException {
		
		try {
			final BinaryOperatorInfo operator = getBinaryOperatorInfo(expression);
			if (operator != null) {
				final String leftOperandString = Expression.substring(0, operator.getIndex()-1, expression).trim();
				final String rightOperandString = Expression.substring(operator.getIndex()+1, expression).trim();
				
				final int a = Integer.parseInt(leftOperandString);
				final int b = Integer.parseInt(rightOperandString);
				
				if (operator.getOperator() == '+') {
					return a + b;
				} else {
					return a - b;
				}
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
