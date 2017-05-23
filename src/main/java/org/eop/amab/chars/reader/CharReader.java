package org.eop.amab.chars.reader;

import org.eop.amab.Position;

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
	
	int skip();
	
	int skip(int count);
	
	void increaseLine();
	
	Position getPosition();
}
