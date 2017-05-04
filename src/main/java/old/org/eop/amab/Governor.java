package old.org.eop.amab;

/**
 * 统治者
 * @author lixinjie
 */
public interface Governor {

	void receive(Mount mount);
	
	Mount getMount();
	
	Mount getGovernedMount();
	
	Place getPlcae();
	
	void govern();
}
