package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;

/**
 * 提辖
 * @author lixinjie
 */
public class Jurisdiction extends AbstractBrother {

	public Jurisdiction(String origin) {
		super(origin);
	}

	public Jurisdiction(Brother parent, String origin) {
		super(parent, origin);
	}

	@Override
	public void train() {
		// parse #set
	}

	@Override
	public String devote() {
		return null;
	}
}
