package old.org.eop.amab.place.parlor.state.matcher;

/**
 * @author lixinjie
 */
public class CvariableMatcher extends VariableMatcher {

	@Override
	public boolean match(String block) {
		return isFirstIsDollar(block) && isSecondIsOpenBrace(block) && !isContainColon(block);
	}

}
