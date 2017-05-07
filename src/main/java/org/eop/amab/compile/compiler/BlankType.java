package org.eop.amab.compile.compiler;

import org.eop.amab.split.Blank;
import org.eop.amab.split.Directive;
import org.eop.amab.split.LineFeed;
import org.eop.amab.split.PlaceHolder;
import org.eop.amab.split.PlainText;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public enum BlankType {

	HeadBlank,
	MidBlank,
	TailBlank,
	OmitBlank,
	RetainBlank,
	
	Unsure,
	None;
	
	public static BlankType tryOf(Section prevSection, Section section) {
		if (section instanceof Blank) {
			if (prevSection == null) {
				return HeadBlank;
			}
			if (prevSection instanceof LineFeed) {
				return HeadBlank;
			}
			return Unsure;
		}
		return None;
	}
	
	public static BlankType tryOf(Section prevSection, Section section, Section nextSection) {
		if (section instanceof Blank) {
			if (prevSection instanceof Directive && nextSection instanceof Directive) {
				return OmitBlank;
			}
			if (prevSection instanceof Directive && nextSection instanceof LineFeed) {
				return OmitBlank;
			}
			if (prevSection instanceof PlainText || prevSection instanceof PlaceHolder) {
				if (nextSection instanceof PlainText || nextSection instanceof PlaceHolder) {
					return RetainBlank;
				}
			}
			if (prevSection instanceof PlainText || prevSection instanceof PlaceHolder) {
				if (nextSection instanceof LineFeed) {
					return TailBlank;
				}
			}
			if (prevSection instanceof PlainText || prevSection instanceof PlaceHolder) {
				if (nextSection instanceof Directive) {
					return MidBlank;
				}
			}
			if (prevSection instanceof Directive) {
				if (nextSection instanceof PlainText || nextSection instanceof PlaceHolder) {
					return MidBlank;
				}
			}
		}
		return None;
	}
}
