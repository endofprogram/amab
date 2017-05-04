package old.org.eop.amab.governor;

import old.org.eop.amab.Governor;
import old.org.eop.amab.Mount;
import old.org.eop.amab.Place;

/**
 * @author lixinjie
 */
public abstract class AbstractGovernor implements Governor {

	protected Mount mount;
	protected Mount gmount;
	protected Place place;
	
	protected AbstractGovernor() {
		
	}
	
	@Override
	public void receive(Mount mount) {
		this.mount = mount;
		initialize();
	}
	
	@Override
	public Mount getMount() {
		return mount;
	}
	
	@Override
	public Mount getGovernedMount() {
		return gmount;
	}
	
	@Override
	public Place getPlcae() {
		return place;
	}
	
	@Override
	public void govern() {
		gmount = getPlcae().discuss();
	}
	
	protected abstract void initialize();
}
