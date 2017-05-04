package org.eop.amab.split;

import org.eop.amab.Location;

/**
 * @author lixinjie
 * @since 2017-05-04
 */
public class Section {

	private String source;
	private Location location;
	
	public Section(String source, Location location) {
		this.source = source;
		this.location = location;
	}
	
	public String getSource() {
		return source;
	}
	public Location getLocation() {
		return location;
	}
	
	@Override
	public String toString() {
		return "Section [source=" + source + ", location=" + location + "]";
	}
	
}
