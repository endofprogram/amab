package org.eop.amab.compile.compiler;

import org.eop.amab.split.Blank;
import org.eop.amab.split.Directive;
import org.eop.amab.split.LineFeed;
import org.eop.amab.split.PlaceHolder;
import org.eop.amab.split.PlainText;
import org.eop.amab.split.Remark;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public enum StatementCategory {

	PositionBlank,
	
	NewLine,
	
	Comment,
	
	Constant,
	
	Output,
	
	Control,
	
	None;
	
	public static StatementCategory tryOf(Section section) {
		if (section == null) {
			return None;
		}
		if (section instanceof Blank) {
			return PositionBlank;
		}
		if (section instanceof LineFeed) {
			return NewLine;
		}
		if (section instanceof Remark) {
			return Comment;
		}
		if (section instanceof PlainText) {
			return Constant;
		}
		if (section instanceof PlaceHolder) {
			return Output;
		}
		if (section instanceof Directive) {
			return Control;
		}
		return None;
	}
	
}
