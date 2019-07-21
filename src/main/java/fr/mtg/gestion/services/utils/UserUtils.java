package fr.mtg.gestion.services.utils;

import java.security.InvalidParameterException;
import java.util.Optional;

import fr.mtg.gestion.entities.nodes.User;
import fr.mtg.gestion.repositories.nodes.UserRepository;

public final class UserUtils {
	
	private UserUtils() {
	}
	
	public static User getUser(UserRepository repository, Long id) {
		if(id != null) {
			Optional<User> user = repository.findById(id);
			if(user.isPresent()) {
				return user.get();
			}
		} throw new InvalidParameterException("Invalid user id : " + id);
	}

}
