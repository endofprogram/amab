package org.eop.amab.exception;

import org.eop.amab.Location;

/**
 * @author lixinjie
 * @since 2017-05-04
 */
public class AmabException extends RuntimeException {

	private static final long serialVersionUID = 8248269297430112342L;
	
	public AmabException(String message) {
        super(message);
    }
	
	public AmabException(Throwable cause) {
        super(cause);
    }
	
	public AmabException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public AmabException(String message, Location location) {
		this(addLocationInfo(message, location));
	}
	
	protected static String addLocationInfo(String message, Location location) {
		return message + location;
	}
}
