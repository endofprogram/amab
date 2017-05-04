package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;

/**
 * 随从
 * @author lixinjie
 */
public class Retinue extends AbstractBrother {

	public Retinue(String origin) {
		super(origin);
	}
	
	public Retinue(Brother parent, String origin) {
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
