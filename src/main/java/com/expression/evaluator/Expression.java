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
	
	
	
	public IExpression parseExpression(String expression) {
		
			
		IExpression result = null;
		
		// Try with BinaryOperation
		final BinaryOperatorInfo operatorInfo = getBinaryOperatorInfo(expression);
		if (operatorInfo != null) {
			
			final BinaryExpression binaryExpression = new BinaryExpression();
			binaryExpression.setOperator(operatorInfo.getOperator());

			final String leftOperandString = Expression.substring(0, operatorInfo.getIndex()-1, expression).trim();
			
			binaryExpression.setA(new UnaryExpression(leftOperandString));
			
			final String rightOperandString = Expression.substring(operatorInfo.getIndex()+1, expression).trim();
			binaryExpression.setB(parseExpression(rightOperandString));
			
			result = binaryExpression;
			
		} else {
		
			result = new UnaryExpression(expression);
		}
		
		return result;
	}
	
	public int evaluate() throws ExpressionParseException {
		
		try {
			
			
			final IExpression exp = parseExpression(expression);
			
			return exp.evaluate();
			
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
