package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;

/**
 * 教头
 * @author lixinjie
 */
public class Coach extends AbstractHeader {

	public Coach(String origin) {
		super(origin);
	}

	public Coach(Brother parent, String origin) {
		super(parent, origin);
	}

	@Override
	public void train() {
		// parse #if #elseif #else
	}

	@Override
	public String devote() {
		return null;
	}
}
