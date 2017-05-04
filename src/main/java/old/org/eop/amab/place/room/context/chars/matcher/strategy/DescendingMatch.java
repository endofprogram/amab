package old.org.eop.amab.place.room.context.chars.matcher.strategy;

import old.org.eop.amab.place.room.context.chars.CharType;
import old.org.eop.amab.place.room.context.chars.matcher.CharsMatcher;
import old.org.eop.amab.place.room.context.chars.matcher.ItemMatcher;
import old.org.eop.amab.place.room.context.chars.matcher.MatchResult;

/**
 * @author lixinjie
 */
public class DescendingMatch extends AbstractMatchStrategy {

	public DescendingMatch(CharsMatcher cmatcher) {
		super(cmatcher);
	}

	@Override
	public boolean match(char[] chars) {
		ItemMatcher[] matchers = getCharsMatcher().getItemMatchers();
		for (int i = chars.length - 1; i >= 0; i--) {
			if (MatchResult.Matched != match(chars[i], matchers)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean match(CharType[] types) {
		ItemMatcher[] matchers = getCharsMatcher().getItemMatchers();
		for (int i = types.length - 1; i >= 0; i--) {
			if (MatchResult.Matched != match(types[i], matchers)) {
				return false;
			}
		}
		return true;
	}

	protected MatchResult match(char c, ItemMatcher[] matchers) {
		for (int i = matchers.length - 1; i >= 0; i--) {
			if (matchers[i].isRetired()) {
				continue;
			}
			MatchResult mresult = matchers[i].match(c);
			if (MatchResult.Unmatched == mresult) {
				if (matchers[i].isQualified()) {
					matchers[i].retire();
					continue;
				}
				return MatchResult.Unmatched;
			}
			return MatchResult.Matched;
		}
		return MatchResult.Usedup;
	}
	
	protected MatchResult match(CharType ct, ItemMatcher[] matchers) {
		for (int i = matchers.length - 1; i >= 0; i--) {
			if (matchers[i].isRetired()) {
				continue;
			}
			MatchResult mresult = matchers[i].match(ct);
			if (MatchResult.Unmatched == mresult) {
				if (matchers[i].isQualified()) {
					matchers[i].retire();
					continue;
				}
				return MatchResult.Unmatched;
			}
			return MatchResult.Matched;
		}
		return MatchResult.Usedup;
	}
}
