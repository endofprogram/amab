package org.eop.amab.compile.expression.compare.bool.arithmetic;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eop.amab.compile.expression.compare.bool.ArithmeticBooleanExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class ArithmeticGreThan<TLeft, TRight> extends ArithmeticBooleanExpression<TLeft, TRight> {

	protected Boolean arithmeticGreThan(byte left, byte right) {
		return left > right;
	}
	
	protected Boolean arithmeticGreThan(short left, short right) {
		return left > right;
	}
	
	protected Boolean arithmeticGreThan(int left, int right) {
		return left > right;
	}
	
	protected Boolean arithmeticGreThan(long left, long right) {
		return left > right;
	}
	
	protected Boolean arithmeticGreThan(float left, float right) {
		return left > right;
	}
	
	protected Boolean arithmeticGreThan(double left, double right) {
		return left > right;
	}
	
	protected Boolean arithmeticGreThan(BigInteger left, BigInteger right) {
		return left.compareTo(right) > 0;
	}
	
	protected Boolean arithmeticGreThan(BigDecimal left, BigDecimal right) {
		return left.compareTo(right) > 0;
	}
	
}
