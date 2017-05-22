package org.eop.amab.compile.expression.logic.bool;

import org.eop.amab.compile.expression.logic.LogicBooleanExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class LogicAnd extends LogicBooleanExpression {

	public Boolean evaluate() {
		return logicAnd(leftOperand.getValue(), rightOperand.getValue());
	}
	
	protected Boolean logicAnd(Boolean left, Boolean right) {
		return left && right;
	}
}
