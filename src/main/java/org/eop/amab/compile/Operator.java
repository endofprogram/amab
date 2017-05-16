package org.eop.amab.compile;

/**
 * @author lixinjie
 * @since 2017-05-16
 */
public enum Operator {

	Add("", 0);
	
	private String symbol;
	private int priority;
	
	private Operator(String symbol, int priority) {
		this.symbol = symbol;
		this.priority = priority;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getPriority() {
		return priority;
	}
	
}
