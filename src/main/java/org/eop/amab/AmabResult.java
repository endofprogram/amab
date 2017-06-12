package org.eop.amab;

/**
 * @author lixinjie
 * @since 2017-06-12
 */
public class AmabResult {

	private StringBuilder buffer;
	
	public AmabResult() {
		buffer = new StringBuilder();
	}
	
	public void write(Object output) {
		buffer.append(output);
	}
	
	public String getOutput() {
		return buffer.toString();
	}
}
