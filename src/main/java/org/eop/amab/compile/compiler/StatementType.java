package org.eop.amab.compile.compiler;

import org.eop.amab.compile.Statement;
import org.eop.amab.compile.statement.Locution;
import org.eop.amab.compile.statement.Output;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public enum StatementType {

	Import,
	
	If,
	Elif,
	Else,
	
	Foreach,
	
	For,
	
	While,
	
	Do,
	
	End,
	
	Assign,
	
	ProtocolOutput,
	
	ContextOutput,
	
	Other,
	
	None;
	
	public static StatementType tryOf(Statement statement) {
		if (statement instanceof Locution) {
			if (statement.getSection().getSource().contains("import")) {
				return Import;
			}
			if (statement.getSection().getSource().contains("elif")) {
				return Elif;
			}
			if (statement.getSection().getSource().contains("if")) {
				return If;
			}
			if (statement.getSection().getSource().contains("else")) {
				return Else;
			}
			if (statement.getSection().getSource().contains("foreach")) {
				return Foreach;
			}
			if (statement.getSection().getSource().contains("for")) {
				return For;
			}
			if (statement.getSection().getSource().contains("while")) {
				return While;
			}
			if (statement.getSection().getSource().contains("do")) {
				return Do;
			}
			if (statement.getSection().getSource().contains("end")) {
				return End;
			}
			if (statement.getSection().getSource().contains("=")) {
				return Assign;
			}
			return None;
		}
		if (statement instanceof Output) {
			if (statement.getSection().getSource().contains("://")) {
				return ProtocolOutput;
			}
			return ContextOutput;
		}
		return Other;
	}
}
