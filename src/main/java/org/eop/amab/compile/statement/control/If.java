package org.eop.amab.compile.statement.control;

import java.util.ArrayList;
import java.util.List;

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
public class If extends Control {

	private Condition condition;
	private AmabContextHolder contextHolder;
	private List<Elif> _elifs = new ArrayList<>();
	private Else _else;
	private End _end;
	
	public If(Section section) {
		super(section);
		contextHolder = new AmabContextHolder();
	}
	
	@Override
	public void compile(AmabSetting setting) {
		int begin = getSection().getSource().indexOf("(") + 1;
		int end = getSection().getSource().lastIndexOf(")");
		String dataName = getSection().getSource().substring(begin, end).trim();
		contextHolder = new AmabContextHolder();
		condition = new Condition(new Fetcher(new Name(dataName, setting.getSetting("claw.identifier")), contextHolder));
		
		for (Statement statement : getChildren()) {
			statement.compile(setting);
		}
		if (hasElif()) {
			for (Elif elif : getElifs()) {
				elif.compile(setting);
			}
		}
		if (hasElse()) {
			getElse().compile(setting);
		}
	}
	
	@Override
	public void execute(AmabSetting setting, AmabContext context, AmabResult result) {
		AmabContext subContext = context.newSubContext();
		contextHolder.setAmabContext(subContext);
		if (condition()) {
			executeIf(setting, subContext, result);
		} else {
			if (hasElif()) {
				if (executeElifs(setting, subContext, result)) {
					return;
				}
			}
			if (hasElse()) {
				executeElse(setting, subContext, result);
			}
		}
	}
	
	protected void executeIf(AmabSetting setting, AmabContext context, AmabResult result) {
		for (Statement statement : getChildren()) {
			statement.execute(setting, context, result);
		}
	}
	
	protected boolean executeElifs(AmabSetting setting, AmabContext context, AmabResult result) {
		for (Elif elif : getElifs()) {
			elif.execute(setting, context, result);
			if (elif.isExecuted()) {
				return true;
			}
		}
		return false;
	}
	
	protected void executeElse(AmabSetting setting, AmabContext context, AmabResult result) {
		getElse().execute(setting, context, result);
	}
	
	public boolean condition() {
		return condition.predicate();
	}
	
	public boolean hasElif() {
		return !_elifs.isEmpty();
	}
	
	public boolean hasElse() {
		return _else != null;
	}
	
	public void addElif(Elif _elif) {
		this._elifs.add(_elif);
	}
	
	public List<Elif> getElifs() {
		return _elifs;
	}
	
	public void setElse(Else _else) {
		this._else = _else;
	}
	
	public Else getElse() {
		return _else;
	}
	
	public void setEnd(End _end) {
		this._end = _end;
	}
	
	public End getEnd() {
		return _end;
	}
	
	@Override
	public String toString() {
		return "If[" + getSection().getSource() + "]";
	}
	
	@Override
	public void display(StringBuilder sb, int indent) {
		displayIndent(sb, indent);
		sb.append(toString());
		displayCrLf(sb, indent);
		displayChildren(sb, indent + 1);
		if (hasElif()) {
			for (Elif elif : getElifs()) {
				elif.display(sb, indent);
			}
		}
		if (hasElse()) {
			getElse().display(sb, indent);
		}
		getEnd().display(sb, indent);
	}
}
