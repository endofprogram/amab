package org.eop.amab.compile.compiler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.eop.amab.compile.Statement;
import org.eop.amab.compile.reader.SectionReader;
import org.eop.amab.compile.reader.StatementReader;
import org.eop.amab.compile.statement.Assign;
import org.eop.amab.compile.statement.Comment;
import org.eop.amab.compile.statement.Constant;
import org.eop.amab.compile.statement.Control;
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
import org.eop.amab.compile.statement.control.Elif;
import org.eop.amab.compile.statement.control.Else;
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
	
	protected static Control compileControlStatement(StatementReader statementReader) {
		switch (getStatementType(statementReader)) {
			case If : return compileIf(statementReader);
			case Elif : return compileElif(statementReader);
			case Else : return compileElse(statementReader);
			case Foreach : return compileForeach(statementReader);
			case For : return compileFor(statementReader);
			case While : return compileWhile(statementReader);
			case Do : return compileDo(statementReader);
			default : return null;
		}
	}
	
	protected static Import compileImport(StatementReader statementReader) {
		Import _import = new Import(statementReader.read().getSection());
		
		return _import;
	}
	
	protected static If compileIf(StatementReader statementReader) {
		If _if = new If(statementReader.read().getSection());
		while (StatementType.tryOf(statementReader.look()) != StatementType.End) {
			addToControl(_if, compileChildStatements(statementReader));
			addToIf(_if, compileControlStatement(statementReader));
		}
		addEndToControl(_if, statementReader.read());
		return _if;
	}
	
	protected static Elif compileElif(StatementReader statementReader) {
		Elif _elif = new Elif(statementReader.read().getSection());
		while (StatementType.tryOf(statementReader.look()) != StatementType.Elif ||
				StatementType.tryOf(statementReader.look()) != StatementType.Else) {
			addToControl(_elif, compileChildStatements(statementReader));
			addToControl(_elif, compileControlStatement(statementReader));
		}
		return _elif;
	}
	
	protected static Else compileElse(StatementReader statementReader) {
		Else _else = new Else(statementReader.read().getSection());
		while (StatementType.tryOf(statementReader.look()) != StatementType.End) {
			addToControl(_else, compileChildStatements(statementReader));
			addToControl(_else, compileControlStatement(statementReader));
		}
		return _else;
	}
	
	protected static Foreach compileForeach(StatementReader statementReader) {
		Foreach _foreach = new Foreach(statementReader.read().getSection());
		while (StatementType.tryOf(statementReader.look()) != StatementType.End) {
			addToControl(_foreach, compileChildStatements(statementReader));
			addToControl(_foreach, compileControlStatement(statementReader));
		}
		return _foreach;
	}
	
	protected static For compileFor(StatementReader statementReader) {
		For _for = new For(statementReader.read().getSection());
		while (StatementType.tryOf(statementReader.look()) != StatementType.End) {
			addToControl(_for, compileChildStatements(statementReader));
			addToControl(_for, compileControlStatement(statementReader));
		}
		return _for;
	}
	
	protected static While compileWhile(StatementReader statementReader) {
		While _while = new While(statementReader.read().getSection());
		while (StatementType.tryOf(statementReader.look()) != StatementType.End) {
			addToControl(_while, compileChildStatements(statementReader));
			addToControl(_while, compileControlStatement(statementReader));
		}
		return _while;
	}
	
	protected static Do compileDo(StatementReader statementReader) {
		Do _do = new Do(statementReader.read().getSection());
		while (StatementType.tryOf(statementReader.look()) != StatementType.While) {
			addToControl(_do, compileChildStatements(statementReader));
			addToControl(_do, compileControlStatement(statementReader));
		}
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
	
	protected static Statement[] compileChildStatements(StatementReader statementReader) {
		List<Statement> statements = new ArrayList<>();
		Set<StatementType> statementTypes = EnumSet.of(StatementType.Other, StatementType.ProtocolOutput, StatementType.ContextOutput, StatementType.Assign);
		Statement statement;
		while (statementTypes.contains(StatementType.tryOf(statement = statementReader.read()))) {
			statements.add(statement);
		}
		statementReader.unread();
		Statement[] sa = new Statement[statements.size()];
		return statements.toArray(sa);
	}
	
	protected static void addToIf(If _if, Control control) {
		if (control != null) {
			if (control instanceof Elif) {
				
			} else if (control instanceof Else) {
				
			}
		}
	}
	
	protected static void addToControl(Control control, Statement[] statements) {
		if (statements != null && statements.length > 0) {
			for (Statement statement : statements) {
				addToControl(control, statement);
			}
		}
	}
	
	protected static void addToControl(Control control, Statement statement) {
		
	}
	
	protected static void addEndToControl(Control control, Statement end) {
		
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
