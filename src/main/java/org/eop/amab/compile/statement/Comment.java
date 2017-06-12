package org.eop.amab.compile.statement;

import org.eop.amab.AmabContext;
import org.eop.amab.AmabResult;
import org.eop.amab.AmabSetting;
import org.eop.amab.compile.Statement;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public class Comment extends Statement {

	public Comment(Section section) {
		super(section);
	}

	@Override
	public void compile(AmabSetting setting) {
		
	}

	@Override
	public void execute(AmabSetting setting, AmabContext context, AmabResult result) {
		if ("true".equals(setting.getSetting("output.comment"))) {
			result.write(getSection().getSource());
		}
	}

}
