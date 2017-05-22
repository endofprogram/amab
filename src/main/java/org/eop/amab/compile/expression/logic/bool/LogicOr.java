package org.eop.amab.compile.expression.logic.bool;

import org.eop.amab.compile.expression.logic.LogicBooleanExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class LogicOr extends LogicBooleanExpression {

	public Boolean evaluate() {
		return logicOr(leftOperand.getValue(), rightOperand.getValue());
	}
	
	protected Boolean logicOr(Boolean left, Boolean right) {
		return left || right;
	}
}
