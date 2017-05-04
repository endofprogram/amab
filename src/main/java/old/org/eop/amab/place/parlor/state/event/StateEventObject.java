package old.org.eop.amab.place.parlor.state.event;

import java.util.EventObject;

/**
 * @author lixinjie
 */
public class StateEventObject extends EventObject {

	private static final long serialVersionUID = -8787870775775603919L;
	private String stateName;
	
	public StateEventObject(Object source, String stateName) {
		super(source);
		this.stateName = stateName;
	}

	public String getStateName() {
		return stateName;
	}
}
