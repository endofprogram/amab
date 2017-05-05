package org.eop.amab.split.reader.chars;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class CharsMatcher {

	private SpecChar[] specChars;
	private SpecChar matchedSpecChar;
	
	private CharsMatcher(SpecChar[] specChars) {
		this.specChars = specChars;
		this.matchedSpecChar = SpecChar.None;
	}
	
	public boolean match(char _char) {
		for (SpecChar specChar : specChars) {
			if (specChar.match(_char)) {
				matchedSpecChar = specChar;
				return true;
			}
		}
		matchedSpecChar = SpecChar.None;
		return false;
	}
	
	public SpecChar getMatchedSpecChar() {
		return matchedSpecChar;
	}
	
	public static CharsMatcher fromSpecChar(SpecChar... specChars) {
		return new CharsMatcher(specChars);
	}
}
