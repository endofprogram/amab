package org.eop.amab.chars;

/**
 * @author lixinjie
 * @since 2017-05-22
 */
public enum EndChar {

	End('\0'),
	None((char)-1);
	
	private char _char;
	
	private EndChar(char _char) {
		this._char = _char;
	}
	
	public boolean match(char _char) {
		return this._char == _char;
	}
	
	public char toChar() {
		return _char;
	}
}
