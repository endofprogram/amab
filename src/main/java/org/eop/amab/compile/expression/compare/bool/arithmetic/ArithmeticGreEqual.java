package org.eop.amab.compile.expression.compare.bool.arithmetic;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eop.amab.compile.expression.compare.bool.ArithmeticBooleanExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class ArithmeticGreEqual<TLeft, TRight> extends ArithmeticBooleanExpression<TLeft, TRight> {

	protected Boolean arithmeticGreEqual(byte left, byte right) {
		return left >= right;
	}
	
	protected Boolean arithmeticGreEqual(short left, short right) {
		return left >= right;
	}
	
	protected Boolean arithmeticGreEqual(int left, int right) {
		return left >= right;
	}
	
	protected Boolean arithmeticGreEqual(long left, long right) {
		return left >= right;
	}
	
	protected Boolean arithmeticGreEqual(float left, float right) {
		return left >= right;
	}
	
	protected Boolean arithmeticGreEqual(double left, double right) {
		return left >= right;
	}
	
	protected Boolean arithmeticGreEqual(BigInteger left, BigInteger right) {
		return left.compareTo(right) >= 0;
	}
	
	protected Boolean arithmeticGreEqual(BigDecimal left, BigDecimal right) {
		return left.compareTo(right) >= 0;
	}
	
}