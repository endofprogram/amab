package org.eop.amab.compile.compiler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.eop.amab.compile.Statement;
import org.eop.amab.compile.reader.SectionReader;
import org.eop.amab.compile.reader.StatementReader;
import org.eop.amab.compile.statement.Comment;
import org.eop.amab.compile.statement.Constant;
import org.eop.amab.compile.statement.Control;
import org.eop.amab.compile.statement.NewLine;
import org.eop.amab.compile.statement.Output;
import org.eop.amab.compile.statement.PositionBlank;
import org.eop.amab.compile.statement.blank.HeadBlank;
import org.eop.amab.compile.statement.blank.MidBlank;
import org.eop.amab.compile.statement.blank.OmitBlank;
import org.eop.amab.compile.statement.blank.RetainBlank;
import org.eop.amab.compile.statement.blank.TailBlank;
import org.eop.amab.compile.statement.control.Elif;
import org.eop.amab.compile.statement.control.Else;
import org.eop.amab.compile.statement.control.End;
import org.eop.amab.compile.statement.control.Foreach;
import org.eop.amab.compile.statement.control.If;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public class StatementCompiler {

	public static Statement compileEntireStatement(StatementReader statementReader) {
		switch (getStatementType(statementReader)) {
			case If : return compileIf(statementReader);
			case Foreach : return compileForeach(statementReader);
			case Other : return compileOther(statementReader);
			default : return null;
		}
	}
	
	protected static StatementType getStatementType(StatementReader statementReader) {
		return StatementType.tryOf(statementReader.look());
	}
	
	
	protected static If compileIf(StatementReader statementReader) {
		If _if = new If(statementReader.read().getSection());
		addChildren(_if, statementReader);
		addElif(_if, statementReader);
		addElse(_if, statementReader);
		addEnd(_if, statementReader);
		return _if;
	}
	
	protected static Elif compileElif(StatementReader statementReader) {
		if (StatementType.tryOf(statementReader.look()) == StatementType.Elif) {
			return new Elif(statementReader.read().getSection());
		}
		return null;
	}
	
	protected static Else compileElse(StatementReader statementReader) {
		if (StatementType.tryOf(statementReader.look()) == StatementType.Else) {
			return new Else(statementReader.read().getSection());
		}
		return null;
	}
	
	protected static End compileEnd(StatementReader statementReader) {
		if (StatementType.tryOf(statementReader.look()) == StatementType.End) {
			return new End(statementReader.read().getSection());
		}
		return null;
	}
	
	protected static Foreach compileForeach(StatementReader statementReader) {
		Foreach _foreach = new Foreach(statementReader.read().getSection());
		addChildren(_foreach, statementReader);
		addEnd(_foreach, statementReader);
		return _foreach;
	}
	
	protected static Statement compileOther(StatementReader statementReader) {
		Statement _other = statementReader.read();
		return _other;
	}
	
	protected static void addChildren(Control control, StatementReader statementReader) {
		Statement[] noncontrolChild = compileNonControlChildStatements(statementReader);
		Control controlChild = compileControlChildStatement(statementReader);
		while (noncontrolChild != null || controlChild != null) {
			if (noncontrolChild != null) {
				addToControl(control, noncontrolChild);
			}
			if (controlChild != null) {
				addToControl(control, controlChild);
			}
			noncontrolChild = compileNonControlChildStatements(statementReader);
			controlChild = compileControlChildStatement(statementReader);
		}
	}
	
	protected static Control compileControlChildStatement(StatementReader statementReader) {
		switch (getStatementType(statementReader)) {
			case If : return compileIf(statementReader);
			case Foreach : return compileForeach(statementReader);
			default : return null;
		}
	}
	
	protected static Statement[] compileNonControlChildStatements(StatementReader statementReader) {
		List<Statement> statements = new ArrayList<>();
		Set<StatementType> statementTypes = EnumSet.of(StatementType.Other);
		StatementType statementType = StatementType.tryOf(statementReader.look());
		while (statementTypes.contains(statementType)) {
			switch (statementType) {
				case Other : statements.add(compileOther(statementReader)); break;
				default : break;
			}
			statementType = StatementType.tryOf(statementReader.look());
		}
		if (statements.isEmpty()) {
			return null;
		}
		Statement[] sa = new Statement[statements.size()];
		return statements.toArray(sa);
	}
	
	protected static void addElif(If _if, StatementReader statementReader) {
		Elif _elif = compileElif(statementReader);
		while (_elif != null) {
			addElif(_if, _elif);
			addChildren(_elif, statementReader);
			_elif = compileElif(statementReader);
		}
	}
	
	protected static void addElif(If _if, Elif _elif) {
		
	}
	
	protected static void addElse(If _if, StatementReader statementReader) {
		Else _else = compileElse(statementReader);
		if (_else != null) {
			addElse(_if, _else);
			addChildren(_else, statementReader);
		}
	}
	
	protected static void addElse(If _if, Else _else) {
		
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
	
	protected static void addEnd(Control control, StatementReader statementReader) {
		End _end = compileEnd(statementReader);
		if (_end != null) {
			addEnd(control);
		} else {
			
		}
	}
	
	protected static void addEnd(Control control) {
		
	}
	
	public static Statement compileSingleStatement(SectionReader sectionReader) {
		switch (getStatementCategory(sectionReader)) {
			case PositionBlank : return compilePositionBlank(sectionReader);
			case NewLine : return compileNewLine(sectionReader);
			case Comment : return compileComment(sectionReader);
			case Constant : return compileConstant(sectionReader);
			case Output : return compileOutput(sectionReader);
			case Control : return compileControl(sectionReader);
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
	
	protected static Control compileControl(SectionReader sectionReader) {
		return new Control(sectionReader.read());
	}
}
