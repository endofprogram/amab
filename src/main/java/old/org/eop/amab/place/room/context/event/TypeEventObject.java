package old.org.eop.amab.place.room.context.event;

import java.util.EventObject;

/**
 * @author lixinjie
 */
public class TypeEventObject extends EventObject {

	private static final long serialVersionUID = -123850940441724876L;
	private StringBuilder sb;
	
	public TypeEventObject(Object source, StringBuilder sb) {
		super(source);
		this.sb = sb;
	}
	
	public StringBuilder getStringBuilder() {
		return sb;
	}
}
