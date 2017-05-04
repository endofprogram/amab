package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;

/**
 * 农民
 * @author lixinjie
 */
public class Farmer extends AbstractBrother {

	public Farmer(String origin) {
		super(origin);
	}
	
	public Farmer(Brother parent, String origin) {
		super(parent, origin);
	}

	@Override
	public void train() {
	}

	@Override
	public String devote() {
		return "";// or origin
	}

}
