package old.org.eop.amab.place.room.context.chars.matcher.strategy;

import old.org.eop.amab.place.room.context.chars.CharType;
import old.org.eop.amab.place.room.context.chars.matcher.CharsMatcher;

/**
 * @author lixinjie
 */
public abstract class AbstractMatchStrategy implements MatchStrategy {

	protected CharsMatcher cmatcher;
	
	protected AbstractMatchStrategy(CharsMatcher cmatcher) {
		this.cmatcher = cmatcher;
	}
	
	@Override
	public CharsMatcher getCharsMatcher() {
		return cmatcher;
	}

	@Override
	public abstract boolean match(char[] chars);
	
	@Override
	public abstract boolean match(CharType[] types);
	
}
