package old.org.eop.amab.place.parlor.state.matcher;

/**
 * @author lixinjie
 */
public class DirectiveMatcher implements BlockMatcher {

	@Override
	public boolean match(String block) {
		return isFirstIsHash(block) && isSecondIsOpenBrace(block);
	}

	protected boolean isFirstIsHash(String block) {
		return '#' == block.charAt(0);
	}
	
	protected boolean isSecondIsOpenBrace(String block) {
		return '{' == block.charAt(1);
	}
	
}
