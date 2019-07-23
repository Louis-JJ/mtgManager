package fr.mtg.gestion.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AuthentificationException extends RuntimeException {

	public AuthentificationException(String msg) {
		super(msg);
	}

}
