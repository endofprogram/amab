package old.org.eop.amab.place;

import java.util.ArrayList;
import java.util.List;

import old.org.eop.amab.Brother;
import old.org.eop.amab.Governor;
import old.org.eop.amab.Mount;
import old.org.eop.amab.mount.Green;
import old.org.eop.amab.mount.Liang;
import old.org.eop.amab.place.parlor.BrotherReader;
import old.org.eop.amab.place.parlor.DefaultBrotherReader;

/**
 * @author lixinjie
 */
public class Parlor extends AbstractPlace {

	private List<Brother> newMount = new ArrayList<>();
	private BrotherReader breader;
	
	public Parlor(Governor governor) {
		super(governor);
		this.breader = new DefaultBrotherReader((Green)getGovernor().getMount());
	}

	@Override
	public Mount discuss() {
		int count;
		do {
			count = breader.readBrother(newMount);
		}while (count != -1);
		return new Liang(newMount);
	}

	
}
