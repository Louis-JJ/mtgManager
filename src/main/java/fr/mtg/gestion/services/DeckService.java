package fr.mtg.gestion.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.mtg.gestion.entities.nodes.Card;
import fr.mtg.gestion.entities.nodes.Deck;
import fr.mtg.gestion.entities.relationships.Commander;
import fr.mtg.gestion.entities.relationships.Contain;
import fr.mtg.gestion.entities.relationships.OwnCard;
import fr.mtg.gestion.entities.relationships.UseDeck;
import fr.mtg.gestion.repositories.nodes.CardRepository;
import fr.mtg.gestion.repositories.nodes.DeckRepository;
import fr.mtg.gestion.repositories.nodes.UserRepository;
import fr.mtg.gestion.repositories.relationships.CommanderRepository;
import fr.mtg.gestion.repositories.relationships.ContainRepository;
import fr.mtg.gestion.repositories.relationships.UsingDeckRepository;
import fr.mtg.gestion.services.utils.SavingUtils;
import fr.mtg.gestion.services.utils.UserUtils;

/**
 * Service class to perform deck's related operations.
 * @author redSpoutnik
 *
 */
@Service
public class DeckService {
	
	/** <b>User</b> Node repository **/
	public final UserRepository userRepository;
	/**  <b>Card</b> Node repository **/
	public final CardRepository cardRepository;
	/**  <b>Deck</b> Node repository **/
	public final DeckRepository deckRepository;
	
	/**  <b>USE</b> Relationship repository **/
	public final UsingDeckRepository usingDeckRepository;
	/**  <b>CONTAIN</b> Relationship repository **/
	public final ContainRepository containRepository;
	/**  <b>COMMANDER</b> Relationship repository **/
	public final CommanderRepository commanderRepository;
	
	public DeckService(
			UserRepository userRepository, 
			CardRepository cardRepository, 
			DeckRepository deckRepository, 
			ContainRepository containRepository, 
			UsingDeckRepository usingDeckRepository, 
			CommanderRepository commanderRepository
			) {
		this.userRepository = userRepository;
		this.cardRepository = cardRepository;
		this.deckRepository = deckRepository;
		this.usingDeckRepository = usingDeckRepository;
		this.containRepository = containRepository;
		this.commanderRepository = commanderRepository;
	}
	
	private Deck addDeckIfDoesntExist(Deck deck) {
		return SavingUtils.saveById(deck, deck::getId, deckRepository);
	}
	
	@Transactional
	public Deck addUserDeck(Long userId, Deck deck) {
		deck = this.addDeckIfDoesntExist(deck);
		
		if(!usingDeckRepository.exist(userId, deck.getId())) {
			UseDeck useDeck = new UseDeck(UserUtils.getUser(userRepository, userId), deck);
			usingDeckRepository.save(useDeck);
		}
		
		return deck;
	}

	@Transactional
	public List<Deck> findUserDecks(Long userId) {
		return deckRepository.getUserDecks(userId);
	}

	@Transactional
	public void addCardToDeck(Card card, Long number, Deck deck) {
		Contain contain = containRepository.find(card.getId(), deck.getId());
		if(contain == null) {
			contain = new Contain(card, number, deck);
			containRepository.save(contain);
		} else if(contain.getNumber() != number) {
			contain.setNumber(number);
			containRepository.save(contain);
		}
	}
	
	@Transactional
	public void addCommanderToDeck(Card card, Deck deck) {
		Commander commander = commanderRepository.find(deck.getId(), card.getId());
		if(commander == null) {
			commander = new Commander(deck, card);
			commanderRepository.save(commander);
		}
	}

}
