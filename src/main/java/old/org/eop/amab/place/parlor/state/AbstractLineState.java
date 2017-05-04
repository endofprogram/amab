package old.org.eop.amab.place.parlor.state;

import java.util.EventObject;
import java.util.List;

import old.org.eop.amab.Brother;
import old.org.eop.amab.brother.Farmer;
import old.org.eop.amab.mount.Green;
import old.org.eop.amab.place.parlor.DefaultBrotherReader;
import old.org.eop.amab.place.parlor.state.brother.Shammer;
import old.org.eop.amab.place.parlor.state.event.StateEventObject;

/**
 * @author lixinjie
 */
public abstract class AbstractLineState implements LineState {

	protected DefaultBrotherReader breader;
	protected Green mount;
	
	protected AbstractLineState(DefaultBrotherReader breader, Green mount) {
		this.breader = breader;
		this.mount = mount;
	}
	
	protected void replaceShammer(int location, Brother brother) {
		breader.replaceShammer(location, brother);
	}
	
	protected int replaceShammer(List<Brother> holder, String bname) {
		int count = 0;
		if ("farmer".equals(bname)) {
			for (Brother brother : holder) {
				if (brother instanceof Shammer) {
					count++;
					Shammer s = (Shammer)brother;
					replaceShammer(s.getLocation(), new Farmer(s.getParent(), s.appear()));
				}
			}
		}
		return count;
	}
	
	protected void fireEvent(String eventName, EventObject eventObject) {
		if ("stateChange".equals(eventName)) {
			onStateChange((StateEventObject)eventObject);
		}
	}
	
	protected void onStateChange(StateEventObject eventObject) {
		breader.changeState(eventObject.getStateName());
	}
	
	protected String read() {
		return mount.read();
	}
	
	protected int unRead() {
		return mount.unread();
	}
	
	protected String lookForward() {
		return mount.lookBackward();
	}
	
	protected String lookBackward() {
		return mount.lookBackward();
	}
	
	@Override
	public abstract int readSingle(List<Brother> holder);

}
