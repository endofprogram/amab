package old.org.eop.amab.place.parlor.state.brother;

import old.org.eop.amab.Brother;
import old.org.eop.amab.brother.AbstractBrother;

/**
 * 冒充者
 * @author lixinjie
 */
public class Shammer extends AbstractBrother {

	private int location;
	
	public Shammer(String origin) {
		this(null, origin);
	}
	
	public Shammer(Brother parent, String origin) {
		super(parent, origin);
	}

	@Override
	public void train() {
	}

	@Override
	public String devote() {
		return null;
	}

	public int getLocation() {
		return location;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
}
