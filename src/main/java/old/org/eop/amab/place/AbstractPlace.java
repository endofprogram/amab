package old.org.eop.amab.place;

import old.org.eop.amab.Governor;
import old.org.eop.amab.Place;

/**
 * @author lixinjie
 */
public abstract class AbstractPlace implements Place {

	private Governor governor;
	
	protected AbstractPlace(Governor governor) {
		this.governor = governor;
	}
	
	@Override
	public Governor getGovernor() {
		return governor;
	}

}
