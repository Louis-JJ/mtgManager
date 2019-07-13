package fr.mtg.gestion.services;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.mtg.gestion.entities.nodes.Card;
import fr.mtg.gestion.entities.nodes.User;
import fr.mtg.gestion.entities.relationships.OwnCard;
import fr.mtg.gestion.repositories.CardRepository;
import fr.mtg.gestion.repositories.OwnershipRepository;
import fr.mtg.gestion.repositories.UserRepository;

@Service
public class CardService {
	
	public final CardRepository cardRepository;
	public final UserRepository userRepository;
	
	public final OwnershipRepository ownershipRepository;
	
	public CardService(CardRepository cardRepository, UserRepository userRepository, OwnershipRepository ownershipRepository) {
		this.cardRepository = cardRepository;
		this.userRepository = userRepository;
		this.ownershipRepository = ownershipRepository;
	}
	
	private User getUser(Long id) {
		if(id != null) {
			Optional<User> user = userRepository.findById(id);
			if(user.isPresent()) {
				return user.get();
			}
		} throw new InvalidParameterException("Invalid user id : " + id);
	}
	
	private <T,U> T saveByParam(T t, Supplier<U> tSupp, Neo4jRepository<T, Long> repository, Function<U, T> rFind) {
		T exist = rFind.apply(tSupp.get());
		return exist == null ? repository.save(t) : exist;
	}
	
	private Card addCardIfDoesntExist(Card card) {
		return this.saveByParam(card, card::getMtgId, cardRepository, cardRepository::findByMtgId);
	}
	
	@Transactional
	public void addCard(Card card) {
		this.addCardIfDoesntExist(card);
	}
	
	@Transactional
	public void addUserCard(Long userId, Card card, short number) {
		card = this.addCardIfDoesntExist(card);
		OwnCard own = ownershipRepository.find(userId, card.getId());
		if(own == null) {
			own = new OwnCard(this.getUser(userId), card, number);
			ownershipRepository.save(own);
		} else if(own.getNumber() != number) {
			own.setNumber(number);
			ownershipRepository.save(own);
		} 
	}
	
	@Transactional
	public List<Card> findAllCards() {
		return (List<Card>) cardRepository.findAll();
	}
	
	@Transactional
	public Iterable<Map<String,Object>> findUserCards(Long userId) {
		return cardRepository.getUserCollection(userId);
	}

}
