package org.eop.amab.compile.expression.compare.bool.string;

import org.eop.amab.compile.expression.compare.bool.StringBooleanExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class StringEqual<TLeft, TRight> extends StringBooleanExpression<TLeft, TRight> {

	public Boolean evaluate() {
		if (leftOperand.getType() == String.class) {
			return stringEqual((String) leftOperand.getValue(), rightOperand.getValue());
		}
		if (rightOperand.getType() == String.class) {
			return stringEqual(leftOperand.getValue(), (String) rightOperand.getValue());
		}
		return null;
	}

	protected Boolean stringEqual(String left, TRight right) {
		return left.equals(right);
	}

	protected Boolean stringEqual(TLeft left, String right) {
		return right.equals(left);
	}
}
