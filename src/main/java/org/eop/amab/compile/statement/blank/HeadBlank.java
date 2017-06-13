package org.eop.amab.compile.statement.blank;

import org.eop.amab.AmabContext;
import org.eop.amab.AmabResult;
import org.eop.amab.AmabSetting;
import org.eop.amab.compile.statement.PositionBlank;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public class HeadBlank extends PositionBlank {

	public HeadBlank(Section section) {
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
		return "HeadBlank[" + getSection().getSource() + "]";
	}
	
	@Override
	public void display(StringBuilder sb, int indent) {
		displayIndent(sb, indent);
		sb.append(toString());
		displayCrLf(sb, indent);
	}
}
