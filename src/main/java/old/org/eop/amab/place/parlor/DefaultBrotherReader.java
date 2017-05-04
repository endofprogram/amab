package old.org.eop.amab.place.parlor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import old.org.eop.amab.Brother;
import old.org.eop.amab.Header;
import old.org.eop.amab.Tailer;
import old.org.eop.amab.mount.Green;
import old.org.eop.amab.place.parlor.state.AbdomenOfLine;
import old.org.eop.amab.place.parlor.state.ChestOfLine;
import old.org.eop.amab.place.parlor.state.HeadOfLine;
import old.org.eop.amab.place.parlor.state.LineState;
import old.org.eop.amab.place.parlor.state.NeckOfLine;
import old.org.eop.amab.place.parlor.state.brother.Shammer;

/**
 * @author lixinjie
 */
public class DefaultBrotherReader implements BrotherReader {

	private Green mount;
	private Header parent;
	private List<Brother> brothers = new ArrayList<>();
	private Map<String, LineState> states = new HashMap<>();
	private LineState state;
	private int stack;
	private int fake;
	
	public DefaultBrotherReader(Green mount) {
		this.mount = mount;
		this.parent = null;
		this.stack = 0;
		this.fake = 0;
		registerStates();
		initializeState();
	}
	
	@Override
	public int readBrother(List<Brother> brothers) {
		clearBrothers();
		Brother brother;
		List<Brother> holder = new ArrayList<>();
		int count;
		while (true) {
			count = state.readSingle(holder);
			if (count < 0) {
				return null;
			}
			if (count < 1) {
				continue;
			}
			brother = addBrother(holder.get(0));
			if (isShammer(brother)) {
				processShammer((Shammer)brother);
			} else {
				if (shouldReturn()) {
					return brothers;
				}
			}
		}
	}
	
	public Brother replaceShammer(int location, Brother brother) {
		fake--;
		if (brother.getParent() == null) {
			brothers.set(location, brother);
		} else {
			((Header)brother.getParent()).getChildren().set(location, brother);
		}
		return brother;
	}
	
	public LineState changeState(String stateName) {
		state = states.get(stateName);
		return state;
	}

	protected Brother addBrother(Brother brother) {
		if (parentExists()) {
			if (brother instanceof Header) {
				parent.addChild(brother);
				stack++;
				parent = (Header)brother;
			} else if (brother instanceof Tailer) {
				parent.setTailer((Tailer)brother);
				stack--;
				parent = (Header)parent.getParent();
			} else {
				parent.addChild(brother);
			}
		} else {
			brothers.add(brother);
			if (brother instanceof Header) {
				stack++;
				parent = (Header)brother;
			}
		}
		return brother;
	}
	
	protected boolean isHeader(Brother brother) {
		return brother instanceof Header;
	}
	
	protected boolean isShammer(Brother brother) {
		return brother instanceof Shammer;
	}
	
	protected void processShammer(Shammer shammer) {
		fake++;
		if (shammer.getParent() == null) {
			shammer.setLocation(brothers.size() - 1);
		} else {
			shammer.setLocation(((Header)shammer.getParent()).getChildren().size() - 1);
		}
	}
	
	protected boolean parentExists() {
		return parent != null;
	}
	
	protected boolean shouldReturn() {
		return stack == 0 && fake == 0;
	}
	
	protected void clearBrothers() {
		brothers.clear();
	}
	
	private void registerStates() {
		states.put("head", new HeadOfLine(this, mount));
		states.put("neck", new NeckOfLine(this, mount));
		states.put("chest", new ChestOfLine(this, mount));
		states.put("abdomen", new AbdomenOfLine(this, mount));
	}
	
	private void initializeState() {
		state = states.get("head");
	}
}
