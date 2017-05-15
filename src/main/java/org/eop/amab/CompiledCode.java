package org.eop.amab;

import java.util.ArrayList;
import java.util.List;

import org.eop.amab.compile.Statement;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class CompiledCode {

	private List<Statement> statements;
	
	public CompiledCode() {
		this.statements = new ArrayList<>();
	}

	public List<Statement> getStatements() {
		return statements;
	}
	
	public void addStatement(Statement statement) {
		statements.add(statement);
	}
}
