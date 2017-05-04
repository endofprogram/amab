package old.org.eop.amab.place.room.context.chars.matcher;

/**
 * @author lixinjie
 */
public enum MatchResult {

	Matched(1),
	Unmatched(-1),
	Usedup(0);
	
	private int result;
	
	private MatchResult(int result) {
		this.result = result;
	}
	
	public int getValue() {
		return result;
	}
}
