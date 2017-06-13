package org.eop.amab.split.exception;

import org.eop.amab.Location;
import org.eop.amab.exception.AmabException;

/**
 * @author lixinjie
 * @since 2017-05-06
 */
public class SourceException extends AmabException {

	private static final long serialVersionUID = -7479081295311123531L;

	public SourceException(String message) {
        super(message);
    }
	
	public SourceException(Throwable cause) {
        super(cause);
    }
	
	public SourceException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public SourceException(String message, Location location) {
		super(message, location);
	}

}
