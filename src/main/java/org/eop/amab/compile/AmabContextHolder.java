package org.eop.amab.compile;

import org.eop.amab.AmabContext;

/**
 * @author lixinjie
 * @since 2017-06-12
 */
public class AmabContextHolder {

	private AmabContext context;
	
	public AmabContextHolder() {
		
	}
	
	public AmabContext getAmabContext() {
		return context;
	}
	
	public void setAmabContext(AmabContext context) {
		this.context = context;
	}
}
