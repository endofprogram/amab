package old.org.eop.amab.place.room.context.chars.matcher;

import java.util.EnumMap;
import java.util.Map;

import old.org.eop.amab.place.room.context.chars.CharType;
import old.org.eop.amab.place.room.context.chars.matcher.strategy.AscendingMatch;
import old.org.eop.amab.place.room.context.chars.matcher.strategy.DescendingMatch;
import old.org.eop.amab.place.room.context.chars.matcher.strategy.MatchStrategy;
import old.org.eop.amab.place.room.context.chars.matcher.strategy.UnorderingMatch;

/**
 * @author lixinjie
 */
public class CharsMatcher {

	private ItemMatcher[] matchers;
	private MatchOrder morder;
	private Map<MatchOrder, MatchStrategy> mstrategies = new EnumMap<>(MatchOrder.class);
	
	public CharsMatcher(ItemMatcher matcher) {
		this(new ItemMatcher[]{matcher});
	}
	
	public CharsMatcher(ItemMatcher... matchers) {
		this(MatchOrder.Unordering, matchers);
	}
	
	public CharsMatcher(MatchOrder morder, ItemMatcher... matchers) {
		this.morder = morder;
		this.matchers = matchers;
		registerMatchStrategies();
	}
	
	public boolean match(char c) {
		return match(new char[]{c});
	}
	
	public boolean match(char[] chars) {
		return getMatchStrategy().match(chars);
	}
	
	public boolean match(CharType type) {
		return match(new CharType[]{type});
	}
	
	public boolean match(CharType[] types) {
		return getMatchStrategy().match(types);
	}
	
	public ItemMatcher[] getItemMatchers() {
		return matchers;
	}
	
	public MatchOrder getMatchOrder() {
		return morder;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (ItemMatcher matcher : matchers) {
			sb.append(matcher.toString());
		}
		return sb.toString();
	}
	
	private MatchStrategy getMatchStrategy() {
		return mstrategies.get(morder);
	}
	
	private void registerMatchStrategies() {
		mstrategies.put(MatchOrder.Ascending, new AscendingMatch(this));
		mstrategies.put(MatchOrder.Descending, new DescendingMatch(this));
		mstrategies.put(MatchOrder.Unordering, new UnorderingMatch(this));
	}
}
