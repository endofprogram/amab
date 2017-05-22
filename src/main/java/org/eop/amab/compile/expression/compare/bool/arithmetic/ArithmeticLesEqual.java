package org.eop.amab.compile.expression.compare.bool.arithmetic;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eop.amab.compile.expression.compare.bool.ArithmeticBooleanExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class ArithmeticLesEqual<TLeft, TRight> extends ArithmeticBooleanExpression<TLeft, TRight> {

	protected Boolean arithmeticLesEqual(byte left, byte right) {
		return left <= right;
	}
	
	protected Boolean arithmeticLesEqual(short left, short right) {
		return left <= right;
	}
	
	protected Boolean arithmeticLesEqual(int left, int right) {
		return left <= right;
	}
	
	protected Boolean arithmeticLesEqual(long left, long right) {
		return left <= right;
	}
	
	protected Boolean arithmeticLesEqual(float left, float right) {
		return left <= right;
	}
	
	protected Boolean arithmeticLesEqual(double left, double right) {
		return left <= right;
	}
	
	protected Boolean arithmeticLesEqual(BigInteger left, BigInteger right) {
		return left.compareTo(right) <= 0;
	}
	
	protected Boolean arithmeticLesEqual(BigDecimal left, BigDecimal right) {
		return left.compareTo(right) <= 0;
	}
	
}
