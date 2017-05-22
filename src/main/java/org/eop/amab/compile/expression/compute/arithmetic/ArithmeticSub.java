package org.eop.amab.compile.expression.compute.arithmetic;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eop.amab.compile.expression.compute.ArithmeticExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class ArithmeticSub<TLeft, TRight, TResult> extends ArithmeticExpression<TLeft, TRight, TResult> {

	protected Byte arithmeticSub(byte left, byte right) {
		return ((Integer)(left - right)).byteValue();
	}
	
	protected Short arithmeticSub(short left, short right) {
		return ((Integer)(left - right)).shortValue();
	}
	
	protected Integer arithmeticSub(int left, int right) {
		return left - right;
	}
	
	protected Long arithmeticSub(long left, long right) {
		return left - right;
	}
	
	protected Float arithmeticSub(float left, float right) {
		return left - right;
	}
	
	protected Double arithmeticSub(double left, double right) {
		return left - right;
	}
	
	protected BigInteger arithmeticSub(BigInteger left, BigInteger right) {
		return left.subtract(right);
	}
	
	protected BigDecimal arithmeticSub(BigDecimal left, BigDecimal right) {
		return left.subtract(right);
	}
}
