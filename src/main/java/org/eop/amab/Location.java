package org.eop.amab;

/**
 * @author lixinjie
 * @since 2017-05-04
 */
public class Location {

	private Position begin;
	private Position end;
	
	public Location(Position begin, Position end) {
		this.begin = begin;
		this.end = end;
	}

	public Position getBegin() {
		return begin;
	}

	public Position getEnd() {
		return end;
	}

}
