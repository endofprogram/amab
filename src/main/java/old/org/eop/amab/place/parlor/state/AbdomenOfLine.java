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
public class AbdomenOfLine extends AbstractLineState {

	public AbdomenOfLine(DefaultBrotherReader breader, Green mount) {
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
			Brother brother = holder.get(holder.size() - 1);
			if (brother instanceof Shammer) {
				Shammer s = (Shammer)brother;
				String origin = s.getOrigin();
				if (s.getOrigin().length() > 1) {
					holder.add(new Plebeian(origin.substring(origin.length() - 1)));
					s.setOrigin(origin.substring(0, origin.length() - 1));
				} else {
					replaceShammer(s.getLocation(), new Plebeian(origin));
				}
			}
			holder.add(DirectiveBuilder.build(block));
			fireEvent("stateChange", new StateEventObject(this, "thigh"));
			return 1;
		}
		if (StateMatcher.Literal.match(block)) {
			replaceShammer(holder, "servant");
			holder.add(new Soldier(block));
			fireEvent("stateChange", new StateEventObject(this, "chest"));
			return 1;
		}
		if (StateMatcher.Cvariable.match(block)) {
			replaceShammer(holder, "retinue");
			holder.add(new Henchman(block));
			return 1;
		}
		if (StateMatcher.Ovariable.match(block)) {
			replaceShammer(holder, "retinue");
			holder.add(new Bawcock(block));
			return 1;
		}
		if (StateMatcher.CRLF.match(block)) {
			replaceShammer(holder, "farmer");
			holder.add(new Farmer(block));
			fireEvent("stateChange", new StateEventObject(this, "head"));
			return 1;
		}
		return 0;
	}

}
