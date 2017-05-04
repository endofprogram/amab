package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;

/**
 * 庶民
 * @author lixinjie
 */
public class Plebeian extends AbstractBrother {

	public Plebeian(String origin) {
		super(origin);
	}

	public Plebeian(Brother parent, String origin) {
		super(parent, origin);
	}

	@Override
	public void train() {
	}

	@Override
	public String devote() {
		return "";
	}
}
