package org.eop.amab.compile.compiler;

import org.eop.amab.split.PlaceHolder;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public enum OutputType {

	Protocol,
	Context,
	
	None;
	
	public static OutputType tryOf(Section section) {
		if (section instanceof PlaceHolder) {
			if (section.getSource().contains("://")) {
				return Protocol;
			} else {
				return Context;
			}
		}
		return None;
	}
}
