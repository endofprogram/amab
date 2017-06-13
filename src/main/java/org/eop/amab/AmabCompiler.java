package org.eop.amab;

import org.eop.amab.compile.Statement;
import org.eop.amab.compile.compiler.StatementCompiler;
import org.eop.amab.compile.reader.DefaultSectionReader;
import org.eop.amab.compile.reader.DefaultStatementReader;
import org.eop.amab.compile.reader.SectionReader;
import org.eop.amab.compile.reader.StatementReader;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class AmabCompiler {

	public static CompiledCode compile(SplitedCode splited, AmabSetting setting) {
		SectionReader sectionReader = new DefaultSectionReader(splited.getSections());
		Statement statement;
		CompiledCode compiledCode = new CompiledCode();
		while ((statement = StatementCompiler.compileSingleStatement(sectionReader)) != null) {
			compiledCode.addStatement(statement);
		}
		StatementReader statementReader = new DefaultStatementReader(compiledCode.getStatements());
		compiledCode = new CompiledCode();
		while ((statement = StatementCompiler.compileCompositeStatement(statementReader)) != null) {
			compiledCode.addStatement(statement);
		}
		statementReader = new DefaultStatementReader(compiledCode.getStatements());
		compiledCode = new CompiledCode();
		while ((statement = StatementCompiler.compileEntireStatement(statementReader, setting)) != null) {
			compiledCode.addStatement(statement);
		}
		return compiledCode;
	}
}
