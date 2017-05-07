package org.eop.amab.split.spliter;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public enum SectionType {

	Blank,
	LineFeed,
	Comment,
	PlainText,
	Output,
	Directive,
	
	End,
	Unsure;
	
	public static SectionType tryOf(char c) {
		if (c == '\0') {
			return End;
		}
		if (c == ' ' || c == '\t') {
			return Blank;
		}
		if (c == '\r' || c == '\n') {
			return LineFeed;
		}
		if ((c != '#' && c != '$') || c == '\\') {
			return PlainText;
		}
		return Unsure;
	}
	
	public static SectionType tryOf(char[] cs) {
		if (cs.length < 2) {
			return PlainText;
		}
		if (cs[0] == '#' && cs[1] == '{') {
			return Directive;
		}
		if (cs[0] == '$' && cs[1] == '{') {
			return Output;
		}
		if (cs[0] == '#' && (cs[1] == '#' || cs[1] == '*')) {
			return Comment;
		}
		return PlainText;
	}
}
