package org.eop.amab.compile.compiler;

import org.eop.amab.compile.Statement;
import org.eop.amab.compile.reader.SectionReader;
import org.eop.amab.compile.reader.StatementReader;
import org.eop.amab.compile.statement.Assign;
import org.eop.amab.compile.statement.Comment;
import org.eop.amab.compile.statement.Constant;
import org.eop.amab.compile.statement.Import;
import org.eop.amab.compile.statement.Locution;
import org.eop.amab.compile.statement.NewLine;
import org.eop.amab.compile.statement.Output;
import org.eop.amab.compile.statement.PositionBlank;
import org.eop.amab.compile.statement.blank.HeadBlank;
import org.eop.amab.compile.statement.blank.MidBlank;
import org.eop.amab.compile.statement.blank.OmitBlank;
import org.eop.amab.compile.statement.blank.RetainBlank;
import org.eop.amab.compile.statement.blank.TailBlank;
import org.eop.amab.compile.statement.control.Do;
import org.eop.amab.compile.statement.control.For;
import org.eop.amab.compile.statement.control.Foreach;
import org.eop.amab.compile.statement.control.If;
import org.eop.amab.compile.statement.control.While;
import org.eop.amab.compile.statement.output.ContextOutput;
import org.eop.amab.compile.statement.output.ProtocolOutput;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public class StatementCompiler {

	public static Statement compileEntireStatement(StatementReader statementReader) {
		switch (getStatementType(statementReader)) {
			case Import : return compileImport(statementReader);
			case If : return compileIf(statementReader);
			case Foreach : return compileForeach(statementReader);
			case For : return compileFor(statementReader);
			case While : return compileWhile(statementReader);
			case Do : return compileDo(statementReader);
			case Assign : return compileAssign(statementReader);
			case ProtocolOutput : return compileProtocolOutput(statementReader);
			case ContextOutput : return compileContextOutput(statementReader);
			case Other : return compileOther(statementReader);
			default : return null;
		}
	}
	
	protected static StatementType getStatementType(StatementReader statementReader) {
		return StatementType.tryOf(statementReader.look());
	}
	
	protected static Import compileImport(StatementReader statementReader) {
		Import _import = new Import(statementReader.read().getSection());
		
		return _import;
	}
	
	protected static If compileIf(StatementReader statementReader) {
		If _if = new If(statementReader.read().getSection());
		
		return _if;
	}
	
	protected static Foreach compileForeach(StatementReader statementReader) {
		Foreach _foreach = new Foreach(statementReader.read().getSection());
		
		return _foreach;
	}
	
	protected static For compileFor(StatementReader statementReader) {
		For _for = new For(statementReader.read().getSection());
		
		return _for;
	}
	
	protected static While compileWhile(StatementReader statementReader) {
		While _while = new While(statementReader.read().getSection());
		
		return _while;
	}
	
	protected static Do compileDo(StatementReader statementReader) {
		Do _do = new Do(statementReader.read().getSection());
		
		return _do;
	}
	
	protected static Assign compileAssign(StatementReader statementReader) {
		Assign _assign = new Assign(statementReader.read().getSection());
		return _assign;
	}
	
	protected static ProtocolOutput compileProtocolOutput(StatementReader statementReader) {
		ProtocolOutput _protocol = new ProtocolOutput(statementReader.read().getSection());
		return _protocol;
	}
	
	protected static ContextOutput compileContextOutput(StatementReader statementReader) {
		ContextOutput _context = new ContextOutput(statementReader.read().getSection());
		return _context;
	}
	
	protected static Statement compileOther(StatementReader statementReader) {
		Statement _other = statementReader.read();
		return _other;
	}
	
	public static Statement compileSingleStatement(SectionReader sectionReader) {
		switch (getStatementCategory(sectionReader)) {
			case PositionBlank : return compilePositionBlank(sectionReader);
			case NewLine : return compileNewLine(sectionReader);
			case Comment : return compileComment(sectionReader);
			case Constant : return compileConstant(sectionReader);
			case Output : return compileOutput(sectionReader);
			case Locution : return compileLocution(sectionReader);
			default : return null;
		}
	}
	
	protected static StatementCategory getStatementCategory(SectionReader sectionReader) {
		return StatementCategory.tryOf(sectionReader.lookNext());
	}
	
	protected static PositionBlank compilePositionBlank(SectionReader sectionReader) {
		switch (getBlankType(sectionReader)) {
			case HeadBlank : return compileHeadBlank(sectionReader);
			case MidBlank : return compileMidBlank(sectionReader);
			case TailBlank : return compileTailBlank(sectionReader);
			case OmitBlank : return compileOmitBlank(sectionReader);
			case RetainBlank : return compileRetainBlank(sectionReader);
			default : return null;
		}
	}
	
	protected static BlankType getBlankType(SectionReader sectionReader) {
		Section section = sectionReader.read();
		BlankType blankType = BlankType.tryOf(sectionReader.lookPrev(), section);
		if (blankType == BlankType.Unsure) {
			blankType = BlankType.tryOf(sectionReader.lookPrev(), section, sectionReader.lookNext());
		}
		sectionReader.unread();
		return blankType;
	}
	
	protected static HeadBlank compileHeadBlank(SectionReader sectionReader) {
		return new HeadBlank(sectionReader.read());
	}
	
	protected static MidBlank compileMidBlank(SectionReader sectionReader) {
		return new MidBlank(sectionReader.read());
	}
	
	protected static TailBlank compileTailBlank(SectionReader sectionReader) {
		return new TailBlank(sectionReader.read());
	}
	
	protected static OmitBlank compileOmitBlank(SectionReader sectionReader) {
		return new OmitBlank(sectionReader.read());
	}
	
	protected static RetainBlank compileRetainBlank(SectionReader sectionReader) {
		return new RetainBlank(sectionReader.read());
	}
	
	protected static NewLine compileNewLine(SectionReader sectionReader) {
		return new NewLine(sectionReader.read());
	}
	
	protected static Comment compileComment(SectionReader sectionReader) {
		return new Comment(sectionReader.read());
	}
	
	protected static Constant compileConstant(SectionReader sectionReader) {
		return new Constant(sectionReader.read());
	}
	
	protected static Output compileOutput(SectionReader sectionReader) {
		return new Output(sectionReader.read());
	}
	
	protected static Locution compileLocution(SectionReader sectionReader) {
		return new Locution(sectionReader.read());
	}
}
