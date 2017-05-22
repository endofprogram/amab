package org.eop.amab.compile.expression.compute.arithmetic;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eop.amab.compile.expression.compute.ArithmeticExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class ArithmeticAdd<TLeft, TRight, TResult> extends ArithmeticExpression<TLeft, TRight, TResult> {

	protected Byte arithmeticAdd(byte left, byte right) {
		return ((Integer)(left + right)).byteValue();
	}
	
	protected Short arithmeticAdd(short left, short right) {
		return ((Integer)(left + right)).shortValue();
	}
	
	protected Integer arithmeticAdd(int left, int right) {
		return left + right;
	}
	
	protected Long arithmeticAdd(long left, long right) {
		return left + right;
	}
	
	protected Float arithmeticAdd(float left, float right) {
		return left + right;
	}
	
	protected Double arithmeticAdd(double left, double right) {
		return left + right;
	}
	
	protected BigInteger arithmeticAdd(BigInteger left, BigInteger right) {
		return left.add(right);
	}
	
	protected BigDecimal arithmeticAdd(BigDecimal left, BigDecimal right) {
		return left.add(right);
	}
}
