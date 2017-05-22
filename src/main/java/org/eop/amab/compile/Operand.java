package org.eop.amab.compile;

/**
 * @author lixinjie
 * @since 2017-05-16
 */
public class Operand<T> {

	protected Class<T> type;
	protected T value;
	
	public Class<T> getType() {
		return type;
	}
	
	public T getValue() {
		return value;
	}
}
