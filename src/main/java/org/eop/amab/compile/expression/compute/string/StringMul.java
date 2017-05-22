package org.eop.amab.compile.expression.compute.string;

import org.eop.amab.compile.expression.compute.StringExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class StringMul extends StringExpression<String, Integer> {

	public String evaluate() {
		return stringMul(leftOperand.getValue(), rightOperand.getValue());
	}
	
	public String stringMul(String left, Integer right) {
		StringBuilder sb = new StringBuilder(left.length() * right);
		for (int i = 0; i < right; i++) {
			sb.append(left);
		}
		return sb.toString();
	}
}
