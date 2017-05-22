package org.eop.amab.compile.expression.compare.bool.arithmetic;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eop.amab.compile.expression.compare.bool.ArithmeticBooleanExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class ArithmeticEqual<TLeft, TRight> extends ArithmeticBooleanExpression<TLeft, TRight> {

	
	
	protected Boolean arithmeticEqual(byte left, byte right) {
		return left == right;
	}
	
	protected Boolean arithmeticEqual(short left, short right) {
		return left == right;
	}
	
	protected Boolean arithmeticEqual(int left, int right) {
		return left == right;
	}
	
	protected Boolean arithmeticEqual(long left, long right) {
		return left == right;
	}
	
	protected Boolean arithmeticEqual(float left, float right) {
		return left == right;
	}
	
	protected Boolean arithmeticEqual(double left, double right) {
		return left == right;
	}
	
	protected Boolean arithmeticEqual(BigInteger left, BigInteger right) {
		return left.compareTo(right) == 0;
	}
	
	protected Boolean arithmeticEqual(BigDecimal left, BigDecimal right) {
		return left.compareTo(right) == 0;
	}
	
}
