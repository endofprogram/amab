package org.eop.amab.compile.statement;

import org.eop.amab.AmabSetting;
import org.eop.amab.compile.Statement;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public abstract class PositionNewLine extends Statement {

	public PositionNewLine(Section section) {
		super(section);
	}

	@Override
	public void compile(AmabSetting setting) {
		
	}

	protected String getCrLfString() {
		if ("\r\n".equals(getSection().getSource())) {
			return "\\r\\n";
		} else if ("\r".equals(getSection().getSource())) {
			return "\\r";
		} else if ("\n".equals(getSection().getSource())) {
			return "\\n";
		}
		return "";
	}
	
	@Override
	public void display(StringBuilder sb, int indent) {
		displayIndent(sb, indent);
		sb.append(toString());
		displayCrLf(sb, indent);
	}
	
}
