package org.eop.amab.split.spliter;

import org.eop.amab.Location;
import org.eop.amab.Position;
import org.eop.amab.split.Blank;
import org.eop.amab.split.Comment;
import org.eop.amab.split.Constant;
import org.eop.amab.split.LineFeed;
import org.eop.amab.split.Output;
import org.eop.amab.split.Section;
import org.eop.amab.split.Statement;
import org.eop.amab.split.exception.SplitException;
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
	
	protected static void checkReachEnd(CharsMatcher charsMatcher, Position begin, Position end) {
		if (charsMatcher.getMatchedSpecChar() == SpecChar.End) {
			throw new SplitException("unexpected end", new Location(begin, end));
		}
	}
	
	protected static Blank splitBlank(CharReader charReader) {
		Position begin = charReader.getPosition();
		char[] chars = readAlways(charReader, CharsMatcher.fromSpecChar(SpecChar.Bspace, SpecChar.Tab));
		Position end = charReader.getPosition();
		return new Blank(new String(chars), new Location(begin, end));
	}
	
	protected static Statement splitStatement(CharReader charReader) {
		Position begin = charReader.getPosition();
		CharArray ca = new CharArray();
		char[] chars = charReader.read(2);
		ca.add(chars);
		CharsMatcher charsMatcher = CharsMatcher.fromSpecChar(SpecChar.Obrace, SpecChar.Cbrace, SpecChar.Squote, SpecChar.Dquote);
		int stack = 1;
		while (stack > 0) {
			Position beg = charReader.getPosition();
			chars = readUntil(charReader, charsMatcher);
			checkReachEnd(charsMatcher, beg, charReader.getPosition());
			ca.add(chars);
			ca.add(charReader.read());
			if (charsMatcher.getMatchedSpecChar() == SpecChar.Obrace) {
				stack++;
			} else if (charsMatcher.getMatchedSpecChar() == SpecChar.Cbrace) {
				stack--;
			} else if (charsMatcher.getMatchedSpecChar() == SpecChar.Squote) {
				beg = charReader.getPosition();
				chars = readUntil(charReader, CharsMatcher.fromSpecChar(SpecChar.Squote));
				checkReachEnd(charsMatcher, beg, charReader.getPosition());
				ca.add(chars);
				ca.add(charReader.read());
			} else if (charsMatcher.getMatchedSpecChar() == SpecChar.Dquote) {
				beg = charReader.getPosition();
				chars = readUntil(charReader, CharsMatcher.fromSpecChar(SpecChar.Dquote));
				checkReachEnd(charsMatcher, beg, charReader.getPosition());
				ca.add(chars);
				ca.add(charReader.read());
			}
		}
		Position end = charReader.getPosition();
		return new Statement(ca.toString(), new Location(begin, end));
	}
	
	protected static Output splitOutput(CharReader charReader) {
		Position begin = charReader.getPosition();
		CharArray ca = new CharArray();
		char[] chars = charReader.read(2);
		ca.add(chars);
		CharsMatcher charsMatcher = CharsMatcher.fromSpecChar(SpecChar.Obrace, SpecChar.Cbrace, SpecChar.Squote, SpecChar.Dquote);
		int stack = 1;
		while (stack > 0) {
			Position beg = charReader.getPosition();
			chars = readUntil(charReader, charsMatcher);
			checkReachEnd(charsMatcher, beg, charReader.getPosition());
			ca.add(chars);
			ca.add(charReader.read());
			if (charsMatcher.getMatchedSpecChar() == SpecChar.Obrace) {
				stack++;
			} else if (charsMatcher.getMatchedSpecChar() == SpecChar.Cbrace) {
				stack--;
			} else if (charsMatcher.getMatchedSpecChar() == SpecChar.Squote) {
				beg = charReader.getPosition();
				chars = readUntil(charReader, CharsMatcher.fromSpecChar(SpecChar.Squote));
				checkReachEnd(charsMatcher, beg, charReader.getPosition());
				ca.add(chars);
				ca.add(charReader.read());
			} else if (charsMatcher.getMatchedSpecChar() == SpecChar.Dquote) {
				beg = charReader.getPosition();
				chars = readUntil(charReader, CharsMatcher.fromSpecChar(SpecChar.Dquote));
				checkReachEnd(charsMatcher, beg, charReader.getPosition());
				ca.add(chars);
				ca.add(charReader.read());
			}
		}
		Position end = charReader.getPosition();
		return new Output(ca.toString(), new Location(begin, end));
	}
	
	protected static Constant splitConstant(CharReader charReader) {
		Position begin = charReader.getPosition();
		CharArray ca = new CharArray();
		CharsMatcher crlfMatcher = CharsMatcher.fromSpecChar(SpecChar.CReturn, SpecChar.LFeed);
		CharsMatcher charsMatcher = CharsMatcher.fromSpecChar(SpecChar.Hash, SpecChar.Dollar, SpecChar.Bslash, SpecChar.CReturn, SpecChar.LFeed);
		while (true) {
			char[] chars = readUntil(charReader, charsMatcher);
			ca.add(chars);
			if (charsMatcher.getMatchedSpecChar() == SpecChar.End) {
				break;
			}
			if (crlfMatcher.match(charsMatcher.getMatchedSpecChar())) {
				break;
			}
			if (charsMatcher.getMatchedSpecChar() == SpecChar.Bslash) {
				charReader.skip();
				ca.add(charReader.read());
			} else if (SectionType.tryOf(charReader.look(2)) == SectionType.Constant) {
				ca.add(charReader.read(2));
			} else {
				break;
			}
		}
		Position end = charReader.getPosition();
		return new Constant(ca.toString(), new Location(begin, end));
	}
	
	protected static Comment splitComment(CharReader charReader) {
		Position begin = charReader.getPosition();
		CharArray ca = new CharArray();
		ca.add(charReader.read());
		char c = charReader.read();
		ca.add(c);
		if (SpecChar.Hash.match(c)) {
			char[] chars = readUntil(charReader, CharsMatcher.fromSpecChar(SpecChar.CReturn, SpecChar.LFeed));
			ca.add(chars);
		} else if (SpecChar.Asterisk.match(c)) {
			CharsMatcher charsMatcher = CharsMatcher.fromSpecChar(SpecChar.Asterisk);
			Position beg = charReader.getPosition();
			char[] chars = readUntil(charReader, charsMatcher);
			checkReachEnd(charsMatcher, beg, charReader.getPosition());
			ca.add(chars);
			ca.add(charReader.read());
			char ch = charReader.read();
			while (!SpecChar.Hash.match(ch)) {
				ca.add(ch);
				beg = charReader.getPosition();
				chars = readUntil(charReader, charsMatcher);
				checkReachEnd(charsMatcher, beg, charReader.getPosition());
				ca.add(chars);
				ca.add(charReader.read());
				ch = charReader.read();
			}
			ca.add(ch);
		}
		Position end = charReader.getPosition();
		return new Comment(ca.toString(), new Location(begin, end));
	}
	
	protected static LineFeed splitLineFeed(CharReader charReader) {
		Position begin = charReader.getPosition();
		char[] chars = readAlways(charReader, CharsMatcher.fromSpecChar(SpecChar.CReturn, SpecChar.LFeed));
		Position end = charReader.getPosition();
		charReader.increaseLine();
		return new LineFeed(new String(chars), new Location(begin, end));
	}

	protected static char[] readAlways(CharReader charReader, CharsMatcher charsMatcher) {
		CharArray ca = new CharArray();
		char c = charReader.read();
		while (charsMatcher.match(c)) {
			ca.add(c);
			c = charReader.read();
		}
		charReader.unread();
		return ca.toArray();
	}
	
	protected static char[] readUntil(CharReader charReader, CharsMatcher charsMatcher) {
		charsMatcher.addSpecChar(SpecChar.End);
		CharsMatcher crlfMatcher = CharsMatcher.fromSpecChar(SpecChar.CReturn, SpecChar.LFeed);
		CharArray ca = new CharArray();
		char c = charReader.read();
		while (!charsMatcher.match(c)) {
			ca.add(c);
			if (crlfMatcher.match(c)) {
				if (crlfMatcher.match(charReader.look())) {
					ca.add(charReader.read());
				}
				charReader.increaseLine();
			}
			c = charReader.read();
		}
		charReader.unread();
		return ca.toArray();
	}
}
