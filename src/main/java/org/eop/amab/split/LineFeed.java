package org.eop.amab.split;

import org.eop.amab.Location;

/**
 * @author lixinjie
 * @since 2017-05-04
 */
public class LineFeed extends Section {

	public LineFeed(Location location) {
		super(System.getProperty("line.separator"), location);
	}

}
