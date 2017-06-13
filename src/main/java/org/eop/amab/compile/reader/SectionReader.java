package org.eop.amab.compile.reader;

import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public interface SectionReader {

	Section read();
	
	Section[] read(int count);
	
	int unread();
	
	int unread(int count);
	
	Section lookNext();
	
	Section[] lookNext(int count);
	
	Section lookPrev();
	
	Section[] lookPrev(int count);
	
	Section lookBack();
	
	boolean isEnd();
}
