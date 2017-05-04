package old.org.eop.amab.place.parlor.state.matcher;

/**
 * @author lixinjie
 */
public class BlankMatcher implements BlockMatcher {

	@Override
	public boolean match(String block) {
		return isFirstIsBlankSpace(block) || isFirstIsTab(block);
	}

	protected boolean isFirstIsBlankSpace(String block) {
		return ' ' == block.charAt(0);
	}
	
	protected boolean isFirstIsTab(String block) {
		return '\t' == block.charAt(0);
	}
}
