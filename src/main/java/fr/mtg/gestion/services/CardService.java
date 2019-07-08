package fr.mtg.gestion.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.mtg.gestion.cardsrepo.CardsRepository;
import fr.mtg.gestion.entities.Cards;

@Service
public class CardService {
	
	public final CardsRepository cardRepository;
	
	public CardService(CardsRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
	@Transactional
	public void addCard(Cards card) {
		cardRepository.save(card);
	}
	
	@Transactional
	public List<Cards> findAll() {
		return (List<Cards>) cardRepository.findAll();
	}

}
