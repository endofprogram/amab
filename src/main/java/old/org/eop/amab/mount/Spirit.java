package old.org.eop.amab.mount;

import old.org.eop.amab.Mount;

/**
 * @author lixinjie
 */
public class Spirit implements Mount {

	private String mount;
	
	public Spirit(String mount) {
		this.mount = mount;
	}
	
	@Override
	public String represent() {
		return mount;
	}

}
