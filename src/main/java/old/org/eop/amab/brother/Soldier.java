package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;

/**
 * 士卒
 * @author lixinjie
 */
public class Soldier extends AbstractBrother {

	public Soldier(String origin) {
		super(origin);
	}

	public Soldier(Brother parent, String origin) {
		super(parent, origin);
	}

	@Override
	public void train() {
	}

	@Override
	public String devote() {
		return origin;
	}
}
