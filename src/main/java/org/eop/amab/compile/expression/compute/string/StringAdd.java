package org.eop.amab.compile.expression.compute.string;

import org.eop.amab.compile.expression.compute.StringExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class StringAdd<TLeft, TRight> extends StringExpression<TLeft, TRight> {

	public String evaluate() {
		if (leftOperand.getType() == String.class) {
			return stringAdd((String)leftOperand.getValue(), rightOperand.getValue());
		}
		if (rightOperand.getType() == String.class) {
			return stringAdd(leftOperand.getValue(), (String)rightOperand.getValue());
		}
		return null;
	}
	
	protected String stringAdd(String left, TRight right) {
		return left + right;
	}
	
	protected String stringAdd(TLeft left, String right) {
		return left + right;
	}
}
