package old.org.eop.amab.place.room.context.chars;

/**
 * @author lixinjie
 */
public class TypeModel {

	private CharRange[] charRanges;
	
	public TypeModel(char c) {
		this(new char[]{c, c});
	}
	
	public TypeModel(char begin, char end) {
		this(new char[]{begin, end});
	}
	
	public TypeModel(char[] pairs) {
		this.charRanges = new CharRange[pairs.length / 2];
		for (int i = 0; i < charRanges.length; i++) {
			charRanges[i] = new CharRange(pairs[i * 2], pairs[i * 2 + 1]);
		}
	}
	
	public boolean match(char c) {
		for (CharRange crange : charRanges) {
			if (crange.match(c)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (CharRange crange : charRanges) {
			sb.append(crange.toString());
		}
		return sb.toString();
	}
	
}
