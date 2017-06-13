package org.eop.amab.compile.reader;

import org.eop.amab.compile.Statement;

/**
 * @author lixinjie
 * @since 2017-05-16
 */
public interface StatementReader {

	Statement read();
	
	int unread();
	
	Statement look();
	
	Statement lookBack();
	
	boolean isEnd();
	
	String display();
}
