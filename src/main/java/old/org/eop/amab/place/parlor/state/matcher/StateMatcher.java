package old.org.eop.amab.place.parlor.state.matcher;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixinjie
 */
public enum StateMatcher {

	Blank("blank"),
	CRLF("crlf"),
	Directive("directive"),
	Comment("comment"),
	Literal("literal"),
	Cvariable("cvariable"),
	Ovariable("ovariable");
	
	private String state;
	private Map<String, BlockMatcher> bmatchers = new HashMap<>();
	
	private StateMatcher(String state) {
		this.state = state;
		initializeMatchers();
	}
	
	public boolean match(String block) {
		return bmatchers.get(state).match(block);
	}
	
	private void initializeMatchers() {
		bmatchers.put("blank", new BlankMatcher());
		bmatchers.put("crlf", new CrlfMatcher());
		bmatchers.put("directive", new DirectiveMatcher());
		bmatchers.put("comment", new CommentMatcher());
		bmatchers.put("literal", new LiteralMatcher());
		bmatchers.put("cvariable", new CvariableMatcher());
		bmatchers.put("ovariable", new OvariableMatcher());
	}
}
