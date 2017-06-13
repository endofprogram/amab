package org.eop.amab.compile.reader;

import java.util.List;

import org.eop.amab.compile.Statement;

/**
 * @author lixinjie
 * @since 2017-05-16
 */
public class DefaultStatementReader implements StatementReader {

	private List<Statement> statements;
	private int index;
	private int length;
	
	public DefaultStatementReader(List<Statement> statements) {
		this.statements = statements;
		this.index = 0;
		this.length = statements.size();
	}
	
	@Override
	public Statement read() {
		if (index < length) {
			Statement statement = statements.get(index);
			index++;
			return statement;
		}
		index++;
		return null;
	}

	@Override
	public int unread() {
		if (index >= 1) {
			index--;
			return 1;
		}
		return 0;
	}

	@Override
	public Statement look() {
		if (index < length) {
			return statements.get(index);
		}
		return null;
	}

	@Override
	public Statement lookBack() {
		if (index > 0) {
			return statements.get(index - 1);
		}
		return null;
	}
	
	@Override
	public boolean isEnd() {
		return index >= length;
	}
}
