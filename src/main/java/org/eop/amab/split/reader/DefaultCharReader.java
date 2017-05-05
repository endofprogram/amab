package org.eop.amab.split.reader;

import org.eop.amab.Position;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class DefaultCharReader implements CharReader {

	private String source;
	private int index;
	private int length;
	private int line;
	private int column;
	
	
	public DefaultCharReader(String source) {
		this.source = source;
		this.index = 0;
		this.length = source.length();
		this.line = 0;
		this.column = 0;
	}
	
	@Override
	public char read() {
		if (index < length) {
			char c = source.charAt(index);
			index++;
			return c;
		}
		return '\0';
	}

	@Override
	public char[] read(int count) {
		if (index < length) {
			int ncount = length - index;
			if (ncount > count) {
				ncount = count;
			}
			char[] cs = new char[ncount];
			for (int i = 0; i < ncount; i++) {
				cs[i] = source.charAt(index);
				index++;
			}
			return cs;
		}
		return new char[0];
	}

	@Override
	public int unread() {
		if (index >= 1) {
			index--;
			return 1;
		}
		return 0;
	}

	@Override
	public int unread(int count) {
		if (index >= count) {
			index -= count;
			return count;
		}
		int ncount = index;
		index = 0;
		return ncount;
	}

	@Override
	public char look() {
		if (index < length) {
			return source.charAt(index);
		}
		return '\0';
	}

	@Override
	public char[] look(int count) {
		if (index < length) {
			int ncount = length - index;
			if (ncount > count) {
				ncount = count;
			}
			char[] cs = new char[ncount];
			for (int i = 0; i < ncount; i++) {
				cs[i] = source.charAt(index + i);
			}
			return cs;
		}
		return new char[0];
	}

	@Override
	public char[] read(int begin, int end) {
		return null;
	}

	@Override
	public char[] read(Position begin, Position end) {
		return null;
	}

	@Override
	public Position getPosition() {
		return new Position(line + 1, column + 1);
	}

}
