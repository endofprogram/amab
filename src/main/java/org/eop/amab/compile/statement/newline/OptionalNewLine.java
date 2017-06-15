package org.eop.amab.compile.statement.newline;

import org.eop.amab.AmabContext;
import org.eop.amab.AmabResult;
import org.eop.amab.AmabSetting;
import org.eop.amab.compile.statement.PositionNewLine;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-06-15
 */
public class OptionalNewLine extends PositionNewLine {

	public OptionalNewLine(Section section) {
		super(section);
	}

	@Override
	public void execute(AmabSetting setting, AmabContext context, AmabResult result) {
		if ("true".equals(setting.getSetting("output.format"))) {
			result.write(getSection().getSource());
		}
	}

	@Override
	public String toString() {
		return "OptionalNewLine[" + getCrLfString() + "]";
	}
}
