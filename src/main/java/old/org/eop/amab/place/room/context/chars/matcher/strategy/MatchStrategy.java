package old.org.eop.amab.place.room.context.chars.matcher.strategy;

import old.org.eop.amab.place.room.context.chars.CharType;
import old.org.eop.amab.place.room.context.chars.matcher.CharsMatcher;

/**
 * @author lixinjie
 */
public interface MatchStrategy {

	CharsMatcher getCharsMatcher();
	
	boolean match(char[] chars);
	
	boolean match(CharType[] types);
}
