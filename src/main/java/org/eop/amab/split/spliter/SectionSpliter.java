package org.eop.amab.split.spliter;

import org.eop.amab.split.Comment;
import org.eop.amab.split.Constant;
import org.eop.amab.split.Declaration;
import org.eop.amab.split.HeadBlank;
import org.eop.amab.split.Import;
import org.eop.amab.split.LineFeed;
import org.eop.amab.split.MidBlank;
import org.eop.amab.split.Output;
import org.eop.amab.split.Statement;
import org.eop.amab.split.TailBlank;
import org.eop.amab.split.reader.CharReader;

/**
 * @author lixinjie
 * @since 2017-05-04
 */
public interface SectionSpliter {

	public Declaration splitDeclaration(CharReader charReader);
	
	public Import splitImport(CharReader charReader);
	
	public HeadBlank splitHeadBlank(CharReader charReader);
	
	public Statement splitStatement(CharReader charReader);
	
	public Output splitOutput(CharReader charReader);
	
	public Constant splitConstant(CharReader charReader);
	
	public MidBlank splitMidBlank(CharReader charReader);
	
	public Comment splitComment(CharReader charReader);
	
	public TailBlank splitTailBlank(CharReader charReader);
	
	public LineFeed splitLineFeed(CharReader charReader);
}
