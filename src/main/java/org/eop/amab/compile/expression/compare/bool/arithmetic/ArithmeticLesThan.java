package org.eop.amab.compile.expression.compare.bool.arithmetic;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eop.amab.compile.expression.compare.bool.ArithmeticBooleanExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class ArithmeticLesThan<TLeft, TRight> extends ArithmeticBooleanExpression<TLeft, TRight> {

	protected Boolean arithmeticLesThan(byte left, byte right) {
		return left < right;
	}
	
	protected Boolean arithmeticLesThan(short left, short right) {
		return left < right;
	}
	
	protected Boolean arithmeticLesThan(int left, int right) {
		return left < right;
	}
	
	protected Boolean arithmeticLesThan(long left, long right) {
		return left < right;
	}
	
	protected Boolean arithmeticLesThan(float left, float right) {
		return left < right;
	}
	
	protected Boolean arithmeticLesThan(double left, double right) {
		return left < right;
	}
	
	protected Boolean arithmeticLesThan(BigInteger left, BigInteger right) {
		return left.compareTo(right) < 0;
	}
	
	protected Boolean arithmeticLesThan(BigDecimal left, BigDecimal right) {
		return left.compareTo(right) < 0;
	}
	
}
