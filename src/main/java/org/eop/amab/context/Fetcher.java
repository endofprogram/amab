package org.eop.amab.context;

import org.eop.amab.compile.AmabContextHolder;
import org.eop.amab.compile.Name;
import org.eop.amab.execute.exception.ExecuteException;
import org.eop.claw.Claw;
import org.eop.claw.IClaw;
import org.eop.claw.IResult;

/**
 * @author lixinjie
 * @since 2017-06-12
 */
public class Fetcher {

	private Name name;
	private AmabContextHolder contextHolder;
	private ExecuteException exception;
	
	public Fetcher(Name name, AmabContextHolder contextHolder) {
		this.name = name;
		this.contextHolder = contextHolder;
	}
	
	public Object fetch() {
		if (contextHolder.getAmabContext().containsVar(name.getName())) {
			clearException();
			return contextHolder.getAmabContext().getVar(name.getName());
		}
		if (contextHolder.getAmabContext().containsVar(name.getPrefix())) {
			Object var = contextHolder.getAmabContext().getVar(name.getPrefix());
			if (name.needClaw()) {
				IClaw claw = new Claw(var);
				IResult result = claw.getResult(name.getPath());
				if (result.isFound()) {
					contextHolder.getAmabContext().addVar(name.getName(), result.getValue());
					clearException();
					return contextHolder.getAmabContext().getVar(name.getName());
				}
				setException(result.getException());
				return null;
			}
			clearException();
			return var;
		}
		setException(null);
		return null;
	}
	
	public Name getName() {
		return name;
	}
	
	public AmabContextHolder getAmabContextHolder() {
		return contextHolder;
	}
	
	public ExecuteException getException() {
		return exception;
	}
	
	protected void clearException() {
		exception = null;
	}
	
	protected void setException(Exception cause) {
		if (cause != null) {
			exception = new ExecuteException("the value not found from context with name '" + name.getName() + "'", cause);
		} else {
			exception = new ExecuteException("the value not found from context with name '" + name.getName() + "'");
		}
	}
}
