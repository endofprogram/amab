package old.org.eop.amab.place.parlor.state.matcher;

/**
 * @author lixinjie
 */
public class LiteralMatcher implements BlockMatcher {

	@Override
	public boolean match(String block) {
		return isFirstNotBlankSpace(block) && isFirstNotTab(block) && isFirstNotHash(block) && isFirstNotCarrageReturn(block) && isFirstNotLineFeed(block) && isFirstNotDollar(block);
	}

	protected boolean isFirstNotBlankSpace(String block) {
		return ' ' != block.charAt(0);
	}
	
	protected boolean isFirstNotTab(String block) {
		return '\t' != block.charAt(0);
	}
	
	protected boolean isFirstNotHash(String block) {
		return '#' != block.charAt(0);
	}
	
	protected boolean isFirstNotCarrageReturn(String block) {
		return '\r' != block.charAt(0);
	}
	
	protected boolean isFirstNotLineFeed(String block) {
		return '\n' != block.charAt(0);
	}
	
	protected boolean isFirstNotDollar(String block) {
		return '$' != block.charAt(0);
	}
}
