package org.eop.amab.compile;

/**
 * @author lixinjie
 * @since 2017-05-16
 */
public class Expression<TLeft, TRight, TResult> extends Operand<TResult> {

	protected Operand<TLeft> leftOperand;
	protected Operator operator;
	protected Operand<TRight> rightOperand;
}
