package org.eop.amab.context;

import org.eop.amab.AmabContext;
import org.eop.amab.compile.Name;

/**
 * @author lixinjie
 * @since 2017-06-12
 */
public class Fetcher {

	private Name name;
	private AmabContext context;
	
	public Fetcher(Name name, AmabContext context) {
		this.name = name;
		this.context = context;
	}
	
	public Object fetch() {
		return null;
	}
	
	public Name getName() {
		return name;
	}
	
	public AmabContext getAmabContext() {
		return context;
	}
}
