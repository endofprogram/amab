package org.eop.amab.split.spliter;

import org.eop.amab.split.Blank;
import org.eop.amab.split.Comment;
import org.eop.amab.split.Constant;
import org.eop.amab.split.LineFeed;
import org.eop.amab.split.Output;
import org.eop.amab.split.Section;
import org.eop.amab.split.Statement;
import org.eop.amab.split.reader.CharReader;
import org.eop.amab.split.reader.chars.CharArray;
import org.eop.amab.split.reader.chars.CharsMatcher;
import org.eop.amab.split.reader.chars.SpecChar;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class SectionSpliter {

	public static Section splitSection(CharReader charReader) {
		switch (getSectionType(charReader)) {
			case Blank : return splitBlank(charReader);
			case Statement : return splitStatement(charReader);
			case Output : return splitOutput(charReader);
			case Constant : return splitConstant(charReader);
			case Comment : return splitComment(charReader);
			case LineFeed : return splitLineFeed(charReader);
			default : return null;
		}
	}
	
	protected static SectionType getSectionType(CharReader charReader) {
		SectionType sectionType = SectionType.tryOf(charReader.look());
		if (sectionType == SectionType.Unsure) {
			sectionType = SectionType.tryOf(charReader.look(2));
		}
		return sectionType;
	}
	
	protected static Blank splitBlank(CharReader charReader) {
		CharsMatcher cm = CharsMatcher.fromSpecChar(SpecChar.Bspace, SpecChar.Tab);
		return null;
	}
	
	protected static Statement splitStatement(CharReader charReader) {
		return null;
	}
	
	protected static Output splitOutput(CharReader charReader) {
		return null;
	}
	
	protected static Constant splitConstant(CharReader charReader) {
		return null;
	}
	
	protected static Comment splitComment(CharReader charReader) {
		return null;
	}
	
	protected static LineFeed splitLineFeed(CharReader charReader) {
		return null;
	}

	protected static char[] readAlways(CharReader charReader, CharsMatcher charsMatcher) {
		CharArray ca = new CharArray();
		char c = charReader.read();
		if (charsMatcher.match(c)) {
			ca.add(c);
		}
		return ca.toArray();
	}
	
	protected static char[] readUntil(CharReader charReader, CharsMatcher charsMatcher) {
		CharArray ca = new CharArray();
		char c = charReader.read();
		if (!charsMatcher.match(c)) {
			ca.add(c);
		}
		return ca.toArray();
	}
}
