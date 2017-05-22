package org.eop.amab.compile.expression.compute.arithmetic;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eop.amab.compile.expression.compute.ArithmeticExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class ArithmeticMul<TLeft, TRight, TResult> extends ArithmeticExpression<TLeft, TRight, TResult> {

	protected Byte arithmeticMul(byte left, byte right) {
		return ((Integer)(left * right)).byteValue();
	}
	
	protected Short arithmeticMul(short left, short right) {
		return ((Integer)(left * right)).shortValue();
	}
	
	protected Integer arithmeticMul(int left, int right) {
		return left * right;
	}
	
	protected Long arithmeticMul(long left, long right) {
		return left * right;
	}
	
	protected Float arithmeticMul(float left, float right) {
		return left * right;
	}
	
	protected Double arithmeticMul(double left, double right) {
		return left * right;
	}
	
	protected BigInteger arithmeticMul(BigInteger left, BigInteger right) {
		return left.multiply(right);
	}
	
	protected BigDecimal arithmeticMul(BigDecimal left, BigDecimal right) {
		return left.multiply(right);
	}
}
