package old.org.eop.amab.mount;

import old.org.eop.amab.Mount;

/**
 * @author lixinjie
 */
public class Wild implements Mount {

	private String mount;
	private int index;
	private int length;
	
	public Wild(String mount) {
		this.mount = mount;
		this.index = 0;
		this.length = mount.length();
	}
	
	@Override
	public String represent() {
		return mount;
	}

	public char[] read(int len) {
		int nlen = len;
		if (index + nlen > length) {
			nlen = length - index;
		}
		char[] chars = getChars(index, nlen);
		index += nlen;
		return chars;
	}
	
	public int unread(int len) {
		int nlen = len;
		if (index - nlen < 0) {
			nlen = index;
			index = 0;
			return nlen;
		}
		index -= nlen;
		return nlen;
	}
	
	public char[] lookForward(int len) {
		int nlen = len;
		if (index + nlen > length) {
			nlen = length - index;
		}
		return getChars(index, nlen);
	}
	
	public char[] lookBackward(int len) {
		if (index - len < 0) {
			return getChars(0, index);
		}
		return getChars(index - len, len);
	}
	
	private char[] getChars(int begin, int len) {
		char[] chars = new char[len];
		for (int i = 0; i < len; i++) {
			chars[i] = mount.charAt(begin + i);
		}
		return chars;
	}
}
