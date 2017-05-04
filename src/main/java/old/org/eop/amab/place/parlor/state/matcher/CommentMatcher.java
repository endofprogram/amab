package old.org.eop.amab.place.parlor.state.matcher;

/**
 * @author lixinjie
 */
public class CommentMatcher implements BlockMatcher {

	@Override
	public boolean match(String block) {
		return isFirstIsHash(block) && (isSecondIsHash(block) || isSecondIsAsterisk(block));
	}

	protected boolean isFirstIsHash(String block) {
		return '#' == block.charAt(0);
	}
	
	protected boolean isSecondIsHash(String block) {
		return '#' == block.charAt(1);
	}
	
	protected boolean isSecondIsAsterisk(String block) {
		return '*' == block.charAt(1);
	}
}
