package org.eop.amab.split.exception;

import org.eop.amab.Location;
import org.eop.amab.exception.AmabException;

/**
 * @author lixinjie
 * @since 2017-05-06
 */
public class SplitException extends AmabException {

	private static final long serialVersionUID = -4825697596562959372L;

	public SplitException(String message, Location location) {
		super(message, location);
	}

}
