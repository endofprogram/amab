package org.eop.amab.compile.expression.compute.arithmetic;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eop.amab.compile.expression.compute.ArithmeticExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class ArithmeticDiv<TLeft, TRight, TResult> extends ArithmeticExpression<TLeft, TRight, TResult> {

	protected Byte arithmeticDiv(byte left, byte right) {
		return ((Integer)(left / right)).byteValue();
	}
	
	protected Short arithmeticDiv(short left, short right) {
		return ((Integer)(left / right)).shortValue();
	}
	
	protected Integer arithmeticDiv(int left, int right) {
		return left / right;
	}
	
	protected Long arithmeticDiv(long left, long right) {
		return left / right;
	}
	
	protected Float arithmeticDiv(float left, float right) {
		return left / right;
	}
	
	protected Double arithmeticDiv(double left, double right) {
		return left / right;
	}
	
	protected BigInteger arithmeticDiv(BigInteger left, BigInteger right) {
		return left.divide(right);
	}
	
	protected BigDecimal arithmeticDiv(BigDecimal left, BigDecimal right) {
		return left.divide(right);
	}
}
