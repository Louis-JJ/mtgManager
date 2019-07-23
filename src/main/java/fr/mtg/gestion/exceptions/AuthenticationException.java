package fr.mtg.gestion.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Authentication exception with HTTP 403 status returned.
 * @author redSpoutnik
 *
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class AuthenticationException extends RuntimeException {

	public AuthenticationException(String msg) {
		super(msg);
	}

}
