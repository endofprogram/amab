package org.eop.amab.compile;

/**
 * @author lixinjie
 * @since 2017-06-12
 */
public class Name {

	private String name;
	private String delimiter;
	
	public Name(String name, String delimiter) {
		this.name = name;
		this.delimiter = delimiter;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDelimiter() {
		return delimiter;
	}
	
	public boolean needClaw() {
		return name.contains(delimiter);
	}
	
	public String getPrefix() {
		if (needClaw()) {
			return name.substring(0, name.indexOf(delimiter));
		}
		return name;
	}
	
	public String getPath() {
		if (needClaw()) {
			return name.substring(name.indexOf(delimiter) + 1);
		}
		return null;
	}
}
