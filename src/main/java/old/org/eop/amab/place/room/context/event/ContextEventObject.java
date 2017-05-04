package old.org.eop.amab.place.room.context.event;

import java.util.EventObject;

import old.org.eop.amab.place.room.context.chars.matcher.CharsMatcher;

/**
 * @author lixinjie
 */
public class ContextEventObject extends EventObject {

	private static final long serialVersionUID = 4892959217687425711L;
	private CharsMatcher matcher;
	
	public ContextEventObject(Object source, CharsMatcher matcher) {
		super(source);
		this.matcher = matcher;
	}
	
	public CharsMatcher getCharMatcher() {
		return matcher;
	}
}