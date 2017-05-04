package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;

/**
 * 探子
 * @author lixinjie
 */
public class Scout extends AbstractBrother {

	public Scout(String origin) {
		super(null, origin);
	}

	public Scout(Brother parent, String origin) {
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
