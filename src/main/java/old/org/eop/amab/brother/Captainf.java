package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;

/**
 * 都尉
 * @author lixinjie
 */
public class Captainf extends AbstractHeader {

	public Captainf(String origin) {
		super(origin);
	}

	public Captainf(Brother parent, String origin) {
		super(parent, origin);
	}

	@Override
	public void train() {
		// parse #foreach
	}

	@Override
	public String devote() {
		return null;
	}
}
