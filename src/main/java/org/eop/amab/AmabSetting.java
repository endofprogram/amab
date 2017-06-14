package org.eop.amab;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixinjie
 * @since 2017-06-12
 */
public class AmabSetting {

	private Map<String, String> settings;
	
	public AmabSetting() {
		settings = new HashMap<>();
		initDefaultSetting();
	}
	
	public AmabSetting(Map<String, String> settings) {
		this();
		initSetting(settings);
	}
	
	public String getSetting(String name) {
		return settings.get(name);
	}
	
	public void addSetting(String name, String value) {
		settings.put(name, value);
	}
	
	public boolean containSetting(String name) {
		return settings.containsKey(name);
	}
	
	protected void initDefaultSetting() {
		addSetting("claw.identifier", ":");
	}
	
	protected void initSetting(Map<String, String> settings) {
		this.settings.putAll(settings);
	}
}
