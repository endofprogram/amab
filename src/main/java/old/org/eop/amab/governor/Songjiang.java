package old.org.eop.amab.governor;

import old.org.eop.amab.place.Hall;

/**
 * @author lixinjie
 */
public class Songjiang extends AbstractGovernor {

	public Songjiang() {
		super();
	}
	
	@Override
	protected void initialize() {
		place = new Hall(this);
	}

}
