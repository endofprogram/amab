package old.org.eop.amab.place.room.context.chars.matcher.strategy;

import old.org.eop.amab.place.room.context.chars.CharType;
import old.org.eop.amab.place.room.context.chars.matcher.CharsMatcher;
import old.org.eop.amab.place.room.context.chars.matcher.ItemMatcher;
import old.org.eop.amab.place.room.context.chars.matcher.MatchResult;

/**
 * @author lixinjie
 */
public class AscendingMatch extends AbstractMatchStrategy {

	public AscendingMatch(CharsMatcher cmatcher) {
		super(cmatcher);
	}

	@Override
	public boolean match(char[] chars) {
		ItemMatcher[] matchers = getCharsMatcher().getItemMatchers();
		for (char c : chars) {
			if (MatchResult.Matched != match(c, matchers)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean match(CharType[] types) {
		ItemMatcher[] matchers = getCharsMatcher().getItemMatchers();
		for (CharType ct : types) {
			if (MatchResult.Matched != match(ct, matchers)) {
				return false;
			}
		}
		return true;
	}
	
	protected MatchResult match(char c, ItemMatcher[] matchers) {
		for (ItemMatcher matcher : matchers) {
			if (matcher.isRetired()) {
				continue;
			}
			MatchResult mresult = matcher.match(c);
			if (MatchResult.Unmatched == mresult) {
				if (matcher.isQualified()) {
					matcher.retire();
					continue;
				}
				return MatchResult.Unmatched;
			}
			return MatchResult.Matched;
		}
		return MatchResult.Usedup;
	}
	
	protected MatchResult match(CharType ct, ItemMatcher[] matchers) {
		for (ItemMatcher matcher : matchers) {
			if (matcher.isRetired()) {
				continue;
			}
			MatchResult mresult = matcher.match(ct);
			if (MatchResult.Unmatched == mresult) {
				if (matcher.isQualified()) {
					matcher.retire();
					continue;
				}
				return MatchResult.Unmatched;
			}
			return MatchResult.Matched;
		}
		return MatchResult.Usedup;
	}
}
