package old.org.eop.amab.place.parlor.state;

import java.util.List;

import old.org.eop.amab.Brother;
import old.org.eop.amab.mount.Green;
import old.org.eop.amab.place.parlor.DefaultBrotherReader;

/**
 * @author lixinjie
 */
public class ThighOfLine extends AbstractLineState {

	public ThighOfLine(DefaultBrotherReader breader, Green mount) {
		super(breader, mount);
	}

	@Override
	public int readSingle(List<Brother> holder) {
		return 0;
	}

}
