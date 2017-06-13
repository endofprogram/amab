package org.eop.amab.split;

import org.eop.amab.Location;

/**
 * @author lixinjie
 * @since 2017-05-04
 */
public class LineFeed extends Section {

	public LineFeed(String source, Location location) {
		super(source, location);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[" + getCrLfString() + "], Location" + getLocation();
	}
	
	protected String getCrLfString() {
		if ("\r\n".equals(getSource())) {
			return "\\r\\n";
		} else if ("\r".equals(getSource())) {
			return "\\r";
		} else if ("\n".equals(getSource())) {
			return "\\n";
		}
		return "";
	}
}
