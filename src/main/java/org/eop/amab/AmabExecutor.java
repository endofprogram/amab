package org.eop.amab;

import org.eop.amab.compile.Statement;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class AmabExecutor {

	public static AmabResult execute(CompiledCode compiled, AmabSetting setting, AmabContext context) {
		AmabResult result = new AmabResult();
		for (Statement statement : compiled.getStatements()) {
			statement.execute(setting, context, result);
		}
		return result;
	}
}
