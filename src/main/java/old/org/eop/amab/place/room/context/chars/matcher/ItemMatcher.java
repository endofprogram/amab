package old.org.eop.amab.place.room.context.chars.matcher;

import old.org.eop.amab.place.room.context.chars.CharType;

/**
 * @author lixinjie
 */
public class ItemMatcher {

	private CharType[] charTypes;
	private int minTimes;
	private int maxTimes;
	private int matchedTimes;
	private MatcherStatus matcherStatus;
	
	public ItemMatcher(CharType... types) {
		this(-1, types);
	}
	
	public ItemMatcher(int times, CharType... charTypes) {
		this(times, times, charTypes);
	}
		
	public ItemMatcher(int minTimes, int maxTimes, CharType... charTypes) {
		this.minTimes = minTimes;
		this.maxTimes = maxTimes;
		this.charTypes = charTypes;
		this.matchedTimes = 0;
		this.matcherStatus = MatcherStatus.Puerile;
	}
	
	public MatchResult match(char c) {
		if (isRetired()) {
			return MatchResult.Usedup;
		}
		if (isMatch(c)) {
			matchedTimes++;
			updateMatcherStatus();
			return MatchResult.Matched;
		}
		return MatchResult.Unmatched;
	}
	
	public MatchResult match(CharType charType) {
		if (isRetired()) {
			return MatchResult.Usedup;
		}
		if (isMatch(charType)) {
			matchedTimes++;
			updateMatcherStatus();
			return MatchResult.Matched;
		}
		return MatchResult.Unmatched;
	}
	
	public boolean isQualified() {
		return matcherStatus == MatcherStatus.Qualified;
	}
	
	public boolean isRetired() {
		return matcherStatus == MatcherStatus.Retired;
	}
	
	public void retire() {
		matcherStatus = MatcherStatus.Retired;
	}
	
	public MatcherStatus getMatcherStatus() {
		return matcherStatus;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (CharType ctype : charTypes) {
			sb.append(ctype.toString());
		}
		return sb.toString();
	}
	
	private boolean isMatch(char c) {
		for (CharType ctype : charTypes) {
			if (ctype.match(c)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isMatch(CharType charType) {
		for (CharType ctype : charTypes) {
			if (ctype == charType) {
				return true;
			}
		}
		return false;
	}
	
	private void updateMatcherStatus() {
		matcherStatus = computeMatcherStatus();
	}
	
	private MatcherStatus computeMatcherStatus() {
		if (minTimes == -1 && maxTimes == -1) {
			return MatcherStatus.Qualified;
		}
		if (minTimes != -1 && maxTimes != -1) {
			if (matchedTimes < minTimes) {
				return MatcherStatus.Puerile;
			}
			if (matchedTimes < maxTimes) {
				return MatcherStatus.Qualified;
			}
			return MatcherStatus.Retired;
		}
		if (minTimes == -1 && maxTimes != -1) {
			if (matchedTimes < maxTimes) {
				return MatcherStatus.Qualified;
			} else {
				return MatcherStatus.Retired;
			}
		}
		if (minTimes != -1 && maxTimes == -1) {
			if (matchedTimes < minTimes) {
				return MatcherStatus.Puerile;
			} else {
				return MatcherStatus.Qualified;
			}
		}
		return null;
	}
}
