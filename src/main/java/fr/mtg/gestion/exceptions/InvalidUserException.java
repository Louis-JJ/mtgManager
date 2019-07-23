package fr.mtg.gestion.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * TODO
 * @author redSpoutnik
 *
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidUserException extends RuntimeException {
	
	public InvalidUserException(Long id) {
		super("Invalid user id : " + id);
	}

}
