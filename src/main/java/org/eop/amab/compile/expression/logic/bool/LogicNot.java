package org.eop.amab.compile.expression.logic.bool;

import org.eop.amab.compile.expression.logic.LogicBooleanExpression;

/**
 * @author lixinjie
 * @since 2017-05-21
 */
public class LogicNot extends LogicBooleanExpression {

	public Boolean evaluate() {
		return logicNot(leftOperand.getValue());
	}
	
	protected Boolean logicNot(Boolean left) {
		return !left;
	}
}
