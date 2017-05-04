package old.org.eop.amab.place.parlor.state.matcher;

/**
 * @author lixinjie
 */
public class CrlfMatcher implements BlockMatcher {

	@Override
	public boolean match(String block) {
		return isFirstIsCarrageReturn(block) || isFirstIsLineFeed(block);
	}

	protected boolean isFirstIsCarrageReturn(String block) {
		return '\r' == block.charAt(0);
	}
	
	protected boolean isFirstIsLineFeed(String block) {
		return '\n' == block.charAt(0);
	}
}
