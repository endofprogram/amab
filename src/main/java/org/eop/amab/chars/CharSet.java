package org.eop.amab.chars;

import java.util.Arrays;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class CharSet {

	private char[] value;
	private int index;
	private int length;
	
	public CharSet() {
		this(128);
	}
	
	public CharSet(int length) {
		this.value = new char[length];
		this.index = 0;
		this.length = length;
	}
	
	public CharSet(char[] chars) {
		this(chars.length * 2);
		initSet(chars);
	}
	
	public void add(char c) {
		ensureLength(index + 1);
		if (!contains(c)) {
			value[index] = c;
			index++;
		}
	}
	
	public void add(char[] ca) {
		ensureLength(length + ca.length);
		for (char c : ca) {
			if (!contains(c)) {
				value[index] = c;
				index++;
			}
		}
	}
	
	public char[] toArray() {
		return Arrays.copyOf(value, index);
	}
	
	@Override
	public String toString() {
		return new String(value, 0, index);
	}
	
	public boolean contains(char c) {
		return Arrays.binarySearch(value, 0, index, c) > -1;
	}
	
	protected void ensureLength(int len) {
		if (len > length) {
			length *= 2;
			value = Arrays.copyOf(value, length);
		}
	}
	
	protected void initSet(char[] chars) {
		add(chars);
	}
}
