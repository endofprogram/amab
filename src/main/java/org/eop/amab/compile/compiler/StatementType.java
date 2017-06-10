package org.eop.amab.compile.compiler;

import org.eop.amab.compile.Statement;
import org.eop.amab.compile.statement.Control;
import org.eop.amab.compile.statement.Output;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public enum StatementType {

	If,
	Elif,
	Else,
	
	Foreach,
	
	End,
	
	DirectOutput,
	ClawOutput,

	Other,
	
	Unknown,
	
	None;
	
	public static StatementType tryOf(Statement statement) {
		if (statement == null) {
			return None;
		}
		if (statement instanceof Control) {
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
			if (statement.getSection().getSource().contains("end")) {
				return End;
			}
			return Unknown;
		}
		if (statement instanceof Output) {
			if (statement.getSection().getSource().contains(":")) {
				return ClawOutput;
			}
			return DirectOutput;
		}
		return Other;
	}
}
