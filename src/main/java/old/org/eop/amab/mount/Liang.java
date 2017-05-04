package old.org.eop.amab.mount;

import java.util.List;

import old.org.eop.amab.Brother;
import old.org.eop.amab.Mount;

/**
 * @author lixinjie
 */
public class Liang implements Mount {

	private List<Brother> mount;
	
	public Liang(List<Brother> mount) {
		this.mount = mount;
	}
	
	@Override
	public List<Brother> represent() {
		return mount;
	}

}
