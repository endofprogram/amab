package org.eop.amab.compile.expression.compare.bool.string;

import org.eop.amab.compile.expression.compare.bool.StringBooleanExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class StringNotEqual<TLeft, TRight> extends StringBooleanExpression<TLeft, TRight> {

	public Boolean evaluate() {
		if (leftOperand.getType() == String.class) {
			return stringNotEqual((String) leftOperand.getValue(), rightOperand.getValue());
		}
		if (rightOperand.getType() == String.class) {
			return stringNotEqual(leftOperand.getValue(), (String) rightOperand.getValue());
		}
		return null;
	}

	protected Boolean stringNotEqual(String left, TRight right) {
		return !left.equals(right);
	}

	protected Boolean stringNotEqual(TLeft left, String right) {
		return !right.equals(left);
	}
}
