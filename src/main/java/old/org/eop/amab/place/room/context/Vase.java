package old.org.eop.amab.place.room.context;

import old.org.eop.amab.mount.Wild;
import old.org.eop.amab.place.room.DefaultTokenReader;
import old.org.eop.amab.place.room.context.event.TypeEventObject;

/**
 * @author lixinjie
 */
public class Vase extends AbstractContext {

	public Vase(DefaultTokenReader treader, Wild mount) {
		super(treader, mount);
	}

	@Override
	public int readBlock(StringBuilder sb) {
		fireEvent("typeChange", new TypeEventObject(this, sb));
		return 0;
	}

}
