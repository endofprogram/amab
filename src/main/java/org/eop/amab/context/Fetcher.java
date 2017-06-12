package org.eop.amab.context;

import org.eop.amab.compile.AmabContextHolder;
import org.eop.amab.compile.Name;
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
	
	public Fetcher(Name name, AmabContextHolder contextHolder) {
		this.name = name;
		this.contextHolder = contextHolder;
	}
	
	public Object fetch() {
		if (contextHolder.getAmabContext().containsVar(name.getName())) {
			return contextHolder.getAmabContext().getVar(name.getName());
		}
		if (contextHolder.getAmabContext().containsVar(name.getPrefix())) {
			Object var = contextHolder.getAmabContext().getVar(name.getPrefix());
			if (name.needClaw()) {
				IClaw claw = new Claw(var);
				IResult result = claw.getResult(name.getPath());
				contextHolder.getAmabContext().addVar(name.getName(), result.getValue());
				return contextHolder.getAmabContext().getVar(name.getName());
			}
			return var;
		}
		return null;
	}
	
	public Name getName() {
		return name;
	}
	
	public AmabContextHolder getAmabContextHolder() {
		return contextHolder;
	}
}
