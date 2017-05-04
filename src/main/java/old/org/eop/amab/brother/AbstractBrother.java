package old.org.eop.amab.brother;

import old.org.eop.amab.Brother;

/**
 * @author lixinjie
 */
public abstract class AbstractBrother implements Brother {

	protected String origin;
	protected Brother parent;
	
	protected AbstractBrother(String origin) {
		this(null, origin);
	}
	
	protected AbstractBrother(Brother parent, String origin) {
		this.parent = parent;
		this.origin = origin;
	}
	
	@Override
	public String appear() {
		return origin;
	}
	
	@Override
	public Brother getParent() {
		return parent;
	}
	
	@Override
	public void setParent(Brother parent) {
		this.parent = parent;
	}
	
	@Override
	public String getOrigin() {
		return origin;
	}
	
	@Override
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	@Override
	public abstract void train();
	
	@Override
	public abstract String devote();
}
