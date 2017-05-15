package org.eop.amab.compile.reader;

import org.eop.amab.compile.Statement;

/**
 * @author lixinjie
 * @since 2017-05-16
 */
public class DefaultStatementReader implements StatementReader {

	@Override
	public Statement read() {
		return null;
	}

	@Override
	public int unread() {
		return 0;
	}

	@Override
	public Statement look() {
		return null;
	}

}
