package org.eop.amab.chars;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class CharsMatcher {

	private CharSet charSet;
	private char matchedChar;
	
	private CharsMatcher(char[] chars) {
		this.charSet = new CharSet(chars);
		this.matchedChar = (char)-1;
	}
	
	public boolean match(char _char) {
		if (charSet.contains(_char)) {
			matchedChar = _char;
			return true;
		}
		matchedChar = (char)-1;
		return false;
	}
	
	public char getMatchedChar() {
		return matchedChar;
	}
	
	public void addChar(char _char) {
		charSet.add(_char);
	}
	
	public static CharsMatcher fromSpecChar(char... chars) {
		return new CharsMatcher(chars);
	}
}
