package fr.mtg.gestion.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Invalid user id exception with HTTP 403 status returned.
 * @author redSpoutnik
 *
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidUserException extends RuntimeException {
	
	public InvalidUserException(Long id) {
		super("Invalid user id : " + id);
	}

}
