package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;
import old.org.eop.amab.Tailer;

/**
 * 军侯
 * @author lixinjie
 */
public class Marquis extends AbstractBrother implements Tailer {

	public Marquis(String origin) {
		super(origin);
	}

	public Marquis(Brother parent, String origin) {
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
