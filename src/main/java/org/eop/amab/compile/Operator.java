package org.eop.amab.compile;

import org.eop.amab.compile.operator.OperChar;

/**
 * @author lixinjie
 * @since 2017-05-16
 */
public enum Operator {

	Add(OperChar.Plus, 0),
	Sub(OperChar.Minus, 0),
	Mul(OperChar.Multiplication, 0),
	Div(OperChar.Division, 0),
	Mod(OperChar.Modulo, 0),
	
	Assign(OperChar.Assignment, 0),
	AddAssign(OperChar.Plus, OperChar.Assignment, 0),
	SubAssign(OperChar.Minus, OperChar.Assignment, 0),
	MulAssign(OperChar.Multiplication, OperChar.Assignment, 0),
	DivAssign(OperChar.Division, OperChar.Assignment, 0),
	ModAssign(OperChar.Modulo, OperChar.Assignment, 0),
	
	
	GreThan(OperChar.CloseAnglebracket, 0),
	LesThan(OperChar.OpenAnglebracket, 0),
	GreEqual(OperChar.CloseAnglebracket, OperChar.Assignment, 0),
	LesEqual(OperChar.OpenAnglebracket, OperChar.Assignment, 0),
	Equal(OperChar.Assignment, OperChar.Assignment, 0),
	NotEqual(OperChar.Exclamation, OperChar.Assignment, 0),
	
	And(OperChar.Ampersand, OperChar.Ampersand, 0),
	Or(OperChar.Verticalbar, OperChar.Verticalbar, 0),
	Not(OperChar.Exclamation, 0);
	
	
	
	private String symbol;
	private int priority;
	
	private Operator(OperChar operChar, int priority) {
		this.symbol = toStr(operChar);
		this.priority = priority;
	}
	
	private Operator(OperChar operChar1, OperChar operChar2, int priority) {
		this.symbol = toStr(operChar1, operChar2);
		this.priority = priority;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getPriority() {
		return priority;
	}
	
	private static String toStr(OperChar operChar) {
		return String.valueOf(operChar.toChar());
	}
	
	private static String toStr(OperChar operChar1, OperChar operChar2) {
			return String.valueOf(new char[]{operChar1.toChar(), operChar2.toChar()});
	}
	
}
