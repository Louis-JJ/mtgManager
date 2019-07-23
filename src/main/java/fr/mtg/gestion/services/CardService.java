package fr.mtg.gestion.services;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.mtg.gestion.entities.nodes.Card;
import fr.mtg.gestion.entities.relationships.Contain;
import fr.mtg.gestion.entities.relationships.OwnCard;
import fr.mtg.gestion.querymanagers.ColorQueryManager;
import fr.mtg.gestion.querymanagers.SearchQueryManager;
import fr.mtg.gestion.repositories.nodes.CardRepository;
import fr.mtg.gestion.repositories.nodes.UserRepository;
import fr.mtg.gestion.repositories.relationships.OwnershipRepository;
import fr.mtg.gestion.services.utils.SavingUtils;
import fr.mtg.gestion.services.utils.UserUtils;

/**
 * Service class to perform card's related operations.
 * @author redSpoutnik
 *
 */
@Service
public class CardService {
	
	/**  <b>User</b> Node repository **/
	public final UserRepository userRepository;
	/**  <b>Card</b> Node repository **/
	public final CardRepository cardRepository;
	
	/**  <b>OWN</b> Relationship repository **/
	public final OwnershipRepository ownershipRepository;
	
	/** Searching card by field Manager **/
	public final SearchQueryManager searchQueryManager;
	/** Searching card by color Manager **/
	public final ColorQueryManager colorQueryManager;
	
	public CardService(
			UserRepository userRepository,
			CardRepository cardRepository,  
			OwnershipRepository ownershipRepository, 
			SearchQueryManager searchQueryConverter, 
			ColorQueryManager colorQueryConverter
			) {
		this.userRepository = userRepository;
		this.cardRepository = cardRepository;;
		this.ownershipRepository = ownershipRepository;
		this.searchQueryManager = searchQueryConverter;
		this.colorQueryManager = colorQueryConverter;
	}
	
	private Card addCardIfDoesntExist(Card card) {
		return SavingUtils.saveByParam(card, card::getMtgId, cardRepository, cardRepository::findByMtgId);
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
			own = new OwnCard(UserUtils.getUser(userRepository, userId), card, number);
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
	
	@Transactional
	public List<Map<String,Object>> findUserCardWithColors(Long userId, String searchType, String searchText, String colors) {
		if(searchQueryManager.validTextSearch(searchType, searchText) && colorQueryManager.validColorPattern(colors)) {
			switch(searchType) {
			case "mtgId": return cardRepository.getUserCardByMtgIdAndColors(userId, searchText, colorQueryManager.colorsToRegex(colors));
			case "nameFr": return cardRepository.getUserCardByNameFrAndColors(userId, searchText, colorQueryManager.colorsToRegex(colors));
			case "nameEn": return cardRepository.getUserCardByNameEnAndColors(userId, searchText, colorQueryManager.colorsToRegex(colors));
			}
		} throw new InvalidParameterException("Invalid parameters to build queries : [TYPE] " + searchType + " [SEARCH] " + searchText + " [COLORS] " + colors);
	}
	
	@Transactional
	public List<Map<String, Object>> findDeckCards(Long userId, Long deckId) {
		return (List<Map<String, Object>>) cardRepository.getDeckCards(userId, deckId);
	}

}
