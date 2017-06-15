package org.eop.amab.compile.compiler;

import org.eop.amab.split.PlaceHolder;
import org.eop.amab.split.PlainText;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-06-15
 */
public enum NewLineType {

	OmitNewLine,
	OptionalNewLine,
	None;
	
	public static NewLineType tryOf(Section[] sections) {
		if (sections == null) {
			return None;
		}
		if (sections.length < 1) {
			return OmitNewLine;
		}
		for (int i = sections.length - 1; i >= 0; i--) {
			if (sections[i] instanceof PlainText || sections[i] instanceof PlaceHolder) {
				return OptionalNewLine;
			}
		}
		return OmitNewLine;
	}
}
