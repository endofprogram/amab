package org.eop.amab.execute.exception;

import org.eop.amab.Location;
import org.eop.amab.exception.AmabException;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public class ExecuteException extends AmabException {

	private static final long serialVersionUID = 4401514807100177968L;

	public ExecuteException(String message) {
        super(message);
    }
	
	public ExecuteException(Throwable cause) {
        super(cause);
    }
	
	public ExecuteException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public ExecuteException(String message, Location location) {
		super(message, location);
	}

}
