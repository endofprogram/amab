package org.eop.amab.chars;

/**
 * @author lixinjie
 * @since 2017-05-22
 */
public enum CrLfChar {
	
	CarriageReturn('\r'),
	LineFeed('\n');
	
	private char _char;
	
	private CrLfChar(char _char) {
		this._char = _char;
	}
	
	public boolean match(char _char) {
		return this._char == _char;
	}
	
	public char toChar() {
		return _char;
	}
}
