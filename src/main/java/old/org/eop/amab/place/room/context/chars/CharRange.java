package old.org.eop.amab.place.room.context.chars;

/**
 * @author lixinjie
 */
public class CharRange {
	
	private char begin;
	private char end;
	
	public CharRange(char begin, char end) {
		this.begin = begin;
		this.end = end;
	}
	
	public boolean match(char c) {
		return begin <= c && c <= end;
	}
	
	@Override
	public String toString() {
		if (begin == end) {
			return toString(begin);
		}
		return toString(begin) + "-" + toString(end);
	}
	
	private String toString(char c) {
		if (c == '\t') return "\\t";
		if (c == '\r') return "\\r";
		if (c == '\n') return "\\n";
		if (c == '\0') return "\\0";
		if (c == (char)-1) return "-1";
		return String.valueOf(c);
	}
	
}
