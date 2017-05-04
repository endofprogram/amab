package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;

/**
 * 亲信
 * @author lixinjie
 */
public class Henchman extends AbstractBrother {

	public Henchman(String origin) {
		super(origin);
	}

	public Henchman(Brother parent, String origin) {
		super(parent, origin);
	}

	@Override
	public void train() {
		// parse ($)
	}

	@Override
	public String devote() {
		return null;
	}
}
