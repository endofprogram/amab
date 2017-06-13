package org.eop.amab.compile.statement.control;

import org.eop.amab.AmabContext;
import org.eop.amab.AmabResult;
import org.eop.amab.AmabSetting;
import org.eop.amab.compile.AmabContextHolder;
import org.eop.amab.compile.Condition;
import org.eop.amab.compile.Name;
import org.eop.amab.compile.Statement;
import org.eop.amab.compile.statement.Control;
import org.eop.amab.context.Fetcher;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public class Elif extends Control {

	private Condition condition;
	private AmabContextHolder contextHolder;
	
	public Elif(Section section) {
		super(section);
		contextHolder = new AmabContextHolder();
	}

	@Override
	public void compile(AmabSetting setting) {
		int begin = getSection().getSource().indexOf("(") + 1;
		int end = getSection().getSource().lastIndexOf(")");
		String dataName = getSection().getSource().substring(begin, end).trim();
		condition = new Condition(new Fetcher(new Name(dataName, setting.getSetting("claw.identifier")), contextHolder));
		
		for (Statement statement : getChildren()) {
			statement.compile(setting);
		}
	}
	
	@Override
	public void execute(AmabSetting setting, AmabContext context, AmabResult result) {
		AmabContext subContext = context.newSubContext();
		contextHolder.setAmabContext(subContext);
		for (Statement statement : getChildren()) {
			statement.execute(setting, subContext, result);
		}
	}
	
	public boolean condition() {
		return condition.predicate();
	}
	
	@Override
	public String toString() {
		return "Elif[" + getSection().getSource() + "]";
	}
	
	@Override
	public void display(StringBuilder sb, int indent) {
		displayIndent(sb, indent);
		sb.append(toString());
		displayCrLf(sb, indent);
		displayChildren(sb, indent + 1);
	}
}
