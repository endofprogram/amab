package old.org.eop.amab.place.parlor.state;

import java.util.List;

import old.org.eop.amab.Brother;
import old.org.eop.amab.brother.Bawcock;
import old.org.eop.amab.brother.Farmer;
import old.org.eop.amab.brother.Henchman;
import old.org.eop.amab.brother.Plebeian;
import old.org.eop.amab.brother.Soldier;
import old.org.eop.amab.mount.Green;
import old.org.eop.amab.place.parlor.DefaultBrotherReader;
import old.org.eop.amab.place.parlor.state.brother.Shammer;
import old.org.eop.amab.place.parlor.state.directive.DirectiveBuilder;
import old.org.eop.amab.place.parlor.state.event.StateEventObject;
import old.org.eop.amab.place.parlor.state.matcher.StateMatcher;

/**
 * @author lixinjie
 */
public class HeadOfLine extends AbstractLineState {

	public HeadOfLine(DefaultBrotherReader breader, Green mount) {
		super(breader, mount);
	}

	@Override
	public int readSingle(List<Brother> holder) {
		String block = read();
		if (StateMatcher.Blank.match(block)) {
			holder.add(new Shammer(block));
			return 1;
		}
		if (StateMatcher.Comment.match(block)) {
			holder.add(new Plebeian(block));
			return 1;
		}
		if (StateMatcher.Directive.match(block)) {
			holder.add(DirectiveBuilder.build(block));
			fireEvent("stateChange", new StateEventObject(this, "neck"));
			return 1;
		}
		if (StateMatcher.Literal.match(block)) {
			replaceShammer(holder, "farmer");
			holder.add(new Soldier(block));
			fireEvent("stateChange", new StateEventObject(this, "chest"));
			return 1;
		}
		if (StateMatcher.Cvariable.match(block)) {
			replaceShammer(holder, "farmer");
			holder.add(new Henchman(block));
			fireEvent("stateChange", new StateEventObject(this, "abdoment"));
			return 1;
		}
		if (StateMatcher.Ovariable.match(block)) {
			replaceShammer(holder, "farmer");
			holder.add(new Bawcock(block));
			fireEvent("stateChange", new StateEventObject(this, "abdoment"));
			return 1;
		}
		if (StateMatcher.CRLF.match(block)) {
			replaceShammer(holder, "farmer");
			holder.add(new Farmer(block));
			return 1;
		}
		return 0;
	}
	
}
