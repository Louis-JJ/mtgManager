package fr.mtg.gestion.services.utils;

import java.util.Optional;

import fr.mtg.gestion.entities.nodes.User;
import fr.mtg.gestion.exceptions.InvalidUserException;
import fr.mtg.gestion.repositories.nodes.UserRepository;

/**
 * Utility class to retrieve User or throw exception.
 * 
 * @author redSpoutnik
 *
 */
public final class UserUtils {
	
	private UserUtils() {
	}
	
	public static User getUser(UserRepository repository, Long id) {
		if(id != null) {
			Optional<User> user = repository.findById(id);
			if(user.isPresent()) {
				return user.get();
			}
		} throw new InvalidUserException(id);
	}

}
