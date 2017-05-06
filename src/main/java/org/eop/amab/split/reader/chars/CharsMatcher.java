package org.eop.amab.split.reader.chars;

import java.util.Arrays;

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
	
	public boolean match(SpecChar specChar) {
		return match(specChar.toChar());
	}
	
	public SpecChar getMatchedSpecChar() {
		return matchedSpecChar;
	}
	
	public void addSpecChar(SpecChar specChar) {
		if (Arrays.binarySearch(specChars, specChar) < 0) {
			specChars = Arrays.copyOf(specChars, specChars.length + 1);
			specChars[specChars.length - 1] = specChar;
		}
	}
	
	public static CharsMatcher fromSpecChar(SpecChar... specChars) {
		return new CharsMatcher(specChars);
	}
}
