package org.eop.amab;

/**
 * @author lixinjie
 * @since 2017-05-04
 */
public class Location {

	private int lineBegin;
	private int lineEnd;
	private int columnBegin;
	private int columnEnd;
	
	public Location(int lineBegin, int lineEnd, int columnBegin, int columnEnd) {
		this.lineBegin = lineBegin;
		this.lineEnd = lineEnd;
		this.columnBegin = columnBegin;
		this.columnEnd = columnEnd;
	}

	public int getLineBegin() {
		return lineBegin;
	}

	public int getLineEnd() {
		return lineEnd;
	}

	public int getColumnBegin() {
		return columnBegin;
	}

	public int getColumnEnd() {
		return columnEnd;
	}

	@Override
	public String toString() {
		return "Location [lineBegin=" + lineBegin + ", lineEnd=" + lineEnd + ", columnBegin=" + columnBegin
				+ ", columnEnd=" + columnEnd + "]";
	}

}
