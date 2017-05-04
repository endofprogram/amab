package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;

/**
 * 都尉
 * @author lixinjie
 */
public class Captainl extends AbstractHeader {

	public Captainl(String origin) {
		super(origin);
	}

	public Captainl(Brother parent, String origin) {
		super(parent, origin);
	}

	@Override
	public void train() {
		// parse #while
	}

	@Override
	public String devote() {
		return null;
	}
}
