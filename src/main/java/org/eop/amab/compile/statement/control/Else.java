package org.eop.amab.compile.statement.control;

import org.eop.amab.AmabContext;
import org.eop.amab.AmabResult;
import org.eop.amab.AmabSetting;
import org.eop.amab.compile.Statement;
import org.eop.amab.compile.statement.Control;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public class Else extends Control {

	public Else(Section section) {
		super(section);
	}

	@Override
	public void execute(AmabSetting setting, AmabContext context, AmabResult result) {
		AmabContext subContext = context.newSubContext();
		for (Statement statement : getChildren()) {
			statement.execute(setting, subContext, result);
		}
	}
}
