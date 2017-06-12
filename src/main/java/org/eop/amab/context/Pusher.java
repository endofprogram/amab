package org.eop.amab.context;

import org.eop.amab.AmabContext;

/**
 * @author lixinjie
 * @since 2017-06-12
 */
public class Pusher {

	private String name;
	private Object value;
	private AmabContext context;
	
	public Pusher(String name, Object value, AmabContext context) {
		this.name = name;
		this.value = value;
		this.context = context;
	}
	
	public void push() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
	
	public AmabContext getAmabContext() {
		return context;
	}
}
