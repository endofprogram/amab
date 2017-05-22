package org.eop.amab.compile.operator;

/**
 * @author lixinjie
 * @since 2017-05-20
 */
public enum OperChar {
	
	Plus('+'),
	Minus('-'),
	Multiplication('*'),
	Division('/'),
	Modulo('%'),
	Assignment('='),
	
	Ampersand('&'),
	Verticalbar('|'),
	Exclamation('!'),
	
	Question('?'),
	Colon(':'),
	
	OpenAnglebracket('<'),
	CloseAnglebracket('>'),
	
	OpenParenthesis('('),
	CloseParenthesis(')'),
	
	OpenSquarebracket('['),
	CloseSquarebracket(']'),
	
	Dot('.'),
	
	None((char)-1);
	
	private char _char;
	
	private OperChar(char _char) {
		this._char = _char;
	}
	
	public char toChar() {
		return _char;
	}
	
	public static OperChar fromChar(char _char) {
		for (OperChar oc : OperChar.values()) {
			if (oc.toChar() == _char) {
				return oc;
			}
		}
		return None;
	}
}
