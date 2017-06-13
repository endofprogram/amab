package org.eop.amab.split.reader.chars;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class CharsMatcher {

	private Set<SpecChar> specCharSet;
	private SpecChar matchedSpecChar;
	
	private CharsMatcher(SpecChar[] specChars) {
		this.specCharSet = EnumSet.copyOf(Arrays.asList(specChars));
		this.matchedSpecChar = SpecChar.None;
	}
	
	public boolean match(char _char) {
		return match(SpecChar.fromChar(_char));
	}
	
	public boolean match(SpecChar specChar) {
		if (specCharSet.contains(specChar)) {
			matchedSpecChar = specChar;
			return true;
		}
		matchedSpecChar = SpecChar.None;
		return false;
	}
	
	public SpecChar getMatchedSpecChar() {
		return matchedSpecChar;
	}
	
	public void addSpecChar(SpecChar specChar) {
		specCharSet.add(specChar);
	}
	
	public static CharsMatcher fromSpecChar(SpecChar... specChars) {
		return new CharsMatcher(specChars);
	}
}
