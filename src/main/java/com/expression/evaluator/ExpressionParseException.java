package com.expression.evaluator;

public class ExpressionParseException extends Exception {

	public ExpressionParseException() {
		super();
	}
	
	public ExpressionParseException(String message) {
		super(message);
	}
	
	public ExpressionParseException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExpressionParseException(Throwable cause) {
		super(cause);
	}

}
