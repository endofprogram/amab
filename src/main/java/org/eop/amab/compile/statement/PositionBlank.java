package org.eop.amab.compile.statement;

import org.eop.amab.AmabSetting;
import org.eop.amab.compile.Statement;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public abstract class PositionBlank extends Statement {

	public PositionBlank(Section section) {
		super(section);
	}

	@Override
	public void compile(AmabSetting setting) {
		
	}
}
