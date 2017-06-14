package org.eop.amab;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixinjie
 * @since 2017-06-12
 */
public class AmabContext {

	private Map<String, Object> container;
	private AmabContext parent;
	
	public AmabContext() {
		container = new HashMap<>();
	}
	
	public AmabContext(AmabContext parent) {
		this();
		this.parent = parent;
	}
	
	public void addVar(String name, Object value) {
		container.put(name, value);
	}
	
	public Object getVar(String name) {
		if (container.containsKey(name)) {
			return container.get(name);
		}
		return parent.getVar(name);
	}
	
	public boolean containsVar(String name) {
		if (container.containsKey(name)) {
			return true;
		}
		if (parent != null) {
			return parent.containsVar(name);
		}
		return false;
	}
	
	public void clearVars() {
		container.clear();
	}
	
	public AmabContext getParent() {
		return parent;
	}
	
	public void setParent(AmabContext parent) {
		this.parent = parent;
	}
	
	public AmabContext newSubContext() {
		return new AmabContext(this);
	}
}
