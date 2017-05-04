package old.org.eop.amab.place.parlor.state.matcher;

/**
 * @author lixinjie
 */
public abstract class VariableMatcher implements BlockMatcher {

	protected boolean isFirstIsDollar(String block) {
		return '$' == block.charAt(0);
	}
	
	protected boolean isSecondIsOpenBrace(String block) {
		return '{' == block.charAt(1);
	}
	
	protected boolean isContainColon(String block) {
		return block.contains(":");
	}
}
