package org.eop.amab.split.reader;

import org.eop.amab.Position;
import org.eop.amab.split.reader.chars.CharsMatcher;

/**
 * @author lixinjie
 * @since 2017-05-04
 */
public interface CharReader {

	char read();
	
	char[] read(int count);
	
	int unread();
	
	int unread(int count);
	
	char look();
	
	char[] look(int count);
	
	char[] read(int begin, int end);
	
	char[] read(Position begin, Position end);
	
	Position getPosition();
}
