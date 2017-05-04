package old.org.eop.amab.governor;

import old.org.eop.amab.place.Room;

/**
 * @author lixinjie
 */
public class Wanglun extends AbstractGovernor {

	public Wanglun() {
		super();
	}

	@Override
	protected void initialize() {
		place = new Room(this);
	}

}
