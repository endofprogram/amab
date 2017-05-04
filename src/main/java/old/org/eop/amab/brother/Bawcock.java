package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;

/**
 * 好汉
 * @author lixinjie
 */
public class Bawcock extends AbstractBrother {

	public Bawcock(String origin) {
		super(origin);
	}

	public Bawcock(Brother parent, String origin) {
		super(parent, origin);
	}

	@Override
	public void train() {
		//parse (:)
	}

	@Override
	public String devote() {
		return null;
	}
}
