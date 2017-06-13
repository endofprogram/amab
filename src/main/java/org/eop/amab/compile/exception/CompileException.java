package org.eop.amab.compile.exception;

import org.eop.amab.Location;
import org.eop.amab.exception.AmabException;

/**
 * @author lixinjie
 * @since 2017-05-07
 */
public class CompileException extends AmabException {

	private static final long serialVersionUID = 4401514807100177968L;

	public CompileException(String message) {
        super(message);
    }
	
	public CompileException(Throwable cause) {
        super(cause);
    }
	
	public CompileException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public CompileException(String message, Location location) {
		super(message, location);
	}

}
