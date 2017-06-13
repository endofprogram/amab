package org.eop.amab.compile.statement;

import org.eop.amab.AmabContext;
import org.eop.amab.AmabResult;
import org.eop.amab.AmabSetting;
import org.eop.amab.compile.AmabContextHolder;
import org.eop.amab.compile.Name;
import org.eop.amab.compile.Statement;
import org.eop.amab.context.Fetcher;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public class Output extends Statement {

	private Fetcher fetcher;
	private AmabContextHolder contextHolder;
	
	public Output(Section section) {
		super(section);
	}

	@Override
	public void compile(AmabSetting setting) {
		int begin = getSection().getSource().indexOf("{") + 1;
		int end = getSection().getSource().lastIndexOf("}");
		String dataName = getSection().getSource().substring(begin, end).trim();
		fetcher = new Fetcher(new Name(dataName, setting.getSetting("claw.identifier")), contextHolder);
	}

	@Override
	public void execute(AmabSetting setting, AmabContext context, AmabResult result) {
		contextHolder.setAmabContext(context);
		result.write(fetcher.fetch());
	}

	@Override
	public String toString() {
		return "Output[" + getSection().getSource() + "]";
	}
	
	@Override
	public void display(StringBuilder sb, int indent) {
		displayIndent(sb, indent);
		sb.append(toString());
		displayCrLf(sb, indent);
	}
}
