package org.eop.amab;

import org.eop.amab.compile.Statement;
import org.eop.amab.compile.compiler.StatementCompiler;
import org.eop.amab.compile.reader.DefaultSectionReader;
import org.eop.amab.compile.reader.SectionReader;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class AmabCompiler {

	public static CompiledCode compile(SplitedCode splited) {
		SectionReader sectionReader = new DefaultSectionReader(splited.getSections());
		Statement statement;
		CompiledCode compiledCode = new CompiledCode();
		while ((statement = StatementCompiler.compileSingleStatement(sectionReader)) != null) {
			compiledCode.addStatement(statement);
		}
		return compiledCode;
	}
}
