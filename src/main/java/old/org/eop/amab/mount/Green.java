package old.org.eop.amab.mount;

import java.util.List;

import old.org.eop.amab.Mount;

/**
 * @author lixinjie
 */
public class Green implements Mount {

	private List<String> mount;
	private int index;
	private int size;
	
	public Green(List<String> mount) {
		this.mount = mount;
		this.index = 0;
		this.size = mount.size();
	}
	
	@Override
	public List<String> represent() {
		return mount;
	}

	public String read() {
		if (index < size) {
			return mount.get(index++);
		}
		return null;
	}
	
	public int unread() {
		if (index > 0) {
			index--;
			return 1;
		}
		return 0;
	}
	
	public String lookForward() {
		if (index < size) {
			return mount.get(index);
		}
		return null;
	}
	
	public String lookBackward() {
		if (index > 0) {
			return mount.get(index - 1);
		}
		return null;
	}
}
