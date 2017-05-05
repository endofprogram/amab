package org.eop.amab.split.spliter;

import org.eop.amab.split.Blank;
import org.eop.amab.split.Comment;
import org.eop.amab.split.Constant;
import org.eop.amab.split.LineFeed;
import org.eop.amab.split.Output;
import org.eop.amab.split.Statement;
import org.eop.amab.split.reader.CharReader;

/**
 * @author lixinjie
 * @since 2017-05-04
 */
public interface SectionSpliter {

	public Blank splitBlank(CharReader charReader);
	
	public Statement splitStatement(CharReader charReader);
	
	public Output splitOutput(CharReader charReader);
	
	public Constant splitConstant(CharReader charReader);
	
	public Comment splitComment(CharReader charReader);
	
	public LineFeed splitLineFeed(CharReader charReader);
}
