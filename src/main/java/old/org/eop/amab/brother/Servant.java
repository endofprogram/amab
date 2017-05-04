package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;

/**
 * 侍者
 * @author lixinjie
 */
public class Servant extends AbstractBrother {

	public Servant(String origin) {
		super(origin);
	}

	public Servant(Brother parent, String origin) {
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
