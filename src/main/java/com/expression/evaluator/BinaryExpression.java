package com.expression.evaluator;

public class BinaryExpression implements IExpression
{
	private IExpression a;
	private IExpression b;
	private char operator;
	
	@Override
	public int evaluate() {
		// TODO Auto-generated method stub
		if (isSum()) {
			return a.evaluate() + b.evaluate();
		} else {
			return a.evaluate() - b.evaluate();	
		}
	}
	
	public void setA(IExpression a) {
		this.a = a;
	}
	
	public IExpression getA() {
		return this.a;
	}
	
	public void setB(IExpression b) {
		this.b = b;
	}
	
	public IExpression getB() {
		return this.b;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}
	
	public boolean isSum() {
		return (this.getOperator() == '+');
	}
	
	public char getOperator() {
		return operator;
	}
}


