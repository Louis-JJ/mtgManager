package fr.mtg.gestion.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.mtg.gestion.entities.nodes.User;
import fr.mtg.gestion.exceptions.AuthentificationException;
import fr.mtg.gestion.repositories.UserRepository;

@Service
public class UserService {
	
	public final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional
	public User signIn(String pseudo) {
		List<User> matchingUser = (List<User>) userRepository.findByPseudo(pseudo);
		if(!matchingUser.isEmpty()) {
			throw new AuthentificationException("User with pseudo [" + pseudo + "] already exist.");
		} return userRepository.save(new User(pseudo));
	}
	
	@Transactional
	public User logIn(String pseudo) {
		List<User> matchingUsers = (List<User>) userRepository.findByPseudo(pseudo);
		if(matchingUsers.isEmpty()) {
			throw new AuthentificationException("No user [" + pseudo + "]");
		} else if(matchingUsers.size() > 1) {
			throw new AuthentificationException("Multiple users for pseudo [" + pseudo + "]");
		} else {
			return matchingUsers.get(0);
		}
	}

}
