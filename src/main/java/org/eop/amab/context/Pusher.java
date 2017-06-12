package org.eop.amab.context;

import org.eop.amab.compile.AmabContextHolder;

/**
 * @author lixinjie
 * @since 2017-06-12
 */
public class Pusher {

	private String name;
	private Object value;
	private AmabContextHolder contextHolder;
	
	public Pusher(String name, Object value, AmabContextHolder contextHolder) {
		this.name = name;
		this.value = value;
		this.contextHolder = contextHolder;
	}
	
	public void push() {
		contextHolder.getAmabContext().addVar(name, value);
	}
	
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
	
	public AmabContextHolder getAmabContextHolder() {
		return contextHolder;
	}
}
