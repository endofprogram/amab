package org.eop.amab.compile;

/**
 * @author lixinjie
 * @since 2017-06-12
 */
public class Name {

	private String name;
	private String identifier;
	
	public Name(String name, String identifier) {
		this.name = name;
		this.identifier = identifier;
	}
	
	public String getName() {
		return name;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public boolean needClaw() {
		return name.contains(identifier);
	}
	
	public String getPrefix() {
		if (needClaw()) {
			return name.substring(0, name.indexOf(identifier));
		}
		return name;
	}
	
	public String getPath() {
		if (needClaw()) {
			return name.substring(name.indexOf(identifier) + 1);
		}
		return null;
	}
}
