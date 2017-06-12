package org.eop.amab.compile.statement.control;

import java.util.ArrayList;
import java.util.List;

import org.eop.amab.AmabContext;
import org.eop.amab.AmabResult;
import org.eop.amab.AmabSetting;
import org.eop.amab.compile.Condition;
import org.eop.amab.compile.Statement;
import org.eop.amab.compile.statement.Control;
import org.eop.amab.split.Section;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public class If extends Control {

	private Condition condition;
	private List<Elif> _elifs = new ArrayList<>();
	private Else _else;
	private End _end;
	
	public If(Section section) {
		super(section);
	}
	
	@Override
	public void execute(AmabSetting setting, AmabContext context, AmabResult result) {
		AmabContext subContext = context.newSubContext();
		if (condition()) {
			executeIf(setting, subContext, result);
		} else if (hasElif()) {
			executeElifs(setting, subContext, result);
		} else if (hasElse()) {
			executeElse(setting, subContext, result);
		}
	}
	
	protected void executeIf(AmabSetting setting, AmabContext context, AmabResult result) {
		for (Statement statement : getChildren()) {
			statement.execute(setting, context, result);
		}
	}
	
	protected void executeElifs(AmabSetting setting, AmabContext context, AmabResult result) {
		for (Elif elif : getElifs()) {
			if (elif.condition()) {
				elif.execute(setting, context, result);
				break;
			}
		}
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
}
