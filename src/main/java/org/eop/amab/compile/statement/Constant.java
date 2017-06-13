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
public class Constant extends Statement {

	public Constant(Section section) {
		super(section);
	}

	@Override
	public void compile(AmabSetting setting) {
		
	}

	@Override
	public void execute(AmabSetting setting, AmabContext context, AmabResult result) {
		result.write(getSection().getSource());
	}

	@Override
	public String toString() {
		return "Constant[" + getSection().getSource() + "]";
	}
	
	@Override
	public void display(StringBuilder sb, int indent) {
		displayIndent(sb, indent);
		sb.append(toString());
		displayCrLf(sb, indent);
	}
}
