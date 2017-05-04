package old.org.eop.amab.governor;

import old.org.eop.amab.place.Parlor;

/**
 * @author lixinjie
 */
public class Chaogai extends AbstractGovernor {

	public Chaogai() {
		super();
	}
	
	@Override
	protected void initialize() {
		place = new Parlor(this);
	}

}
