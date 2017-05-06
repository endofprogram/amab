package org.eop.amab.split.reader.chars;

import java.util.Arrays;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class CharArray {

	private char[] value;
	private int index;
	private int length;
	
	public CharArray() {
		this(128);
	}
	
	public CharArray(int length) {
		this.value = new char[length];
		this.index = 0;
		this.length = length;
	}
	
	public void add(char c) {
		ensureLength(index + 1);
		value[index] = c;
		index++;
	}
	
	public void add(char[] ca) {
		ensureLength(length + ca.length);
		for (char c : ca) {
			value[index] = c;
			index++;
		}
	}
	
	public char[] toArray() {
		return Arrays.copyOf(value, index);
	}
	
	@Override
	public String toString() {
		return new String(value, 0, index);
	}
	
	protected void ensureLength(int len) {
		if (len > length) {
			length *= 2;
			value = Arrays.copyOf(value, length);
		}
	}
}
