package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;

/**
 * 都尉
 * @author lixinjie
 */
public class Captainb extends AbstractHeader {

	public Captainb(String origin) {
		super(origin);
	}

	public Captainb(Brother parent, String origin) {
		super(parent, origin);
	}

	@Override
	public void train() {
		// parse #for
	}

	@Override
	public String devote() {
		return null;
	}
}
