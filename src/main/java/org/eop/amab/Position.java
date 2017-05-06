package org.eop.amab;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class Position {

	private int line;
	private int column;
	
	public Position() {
		this(0, 0);
	}
	
	public Position(int line, int column) {
		super();
		this.line = line;
		this.column = column;
	}
	
	public int getLine() {
		return line;
	}
	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return "(" + line + "," + column + ")";
	}
	
}
