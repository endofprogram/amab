package org.eop.amab;

/**
 * @author lixinjie
 * @since 2017-06-14
 */
public class AmabManager {

	public static CompiledCode compile(SourceCode source, AmabSetting setting) {
		SplitedCode splited = AmabSpliter.split(source);
		CompiledCode compiled = AmabCompiler.compile(splited, setting);
		return compiled;
	}
	
	public static AmabResult execute(CompiledCode compiled, AmabSetting setting, AmabContext context) {
		return AmabExecutor.execute(compiled, setting, context);
	}
}
