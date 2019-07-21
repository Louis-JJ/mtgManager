package fr.mtg.gestion.entities.requests;

import fr.mtg.gestion.entities.nodes.Card;
import fr.mtg.gestion.entities.nodes.Deck;

public class CardDeckRequest {
	
	private Card card;
	private Long number;
	private String commander;
	private Deck deck;
	
	public Card getCard() {
		return card;
	}
	public Long getNumber() {
		return number;
	}
	public String getCommander() {
		return commander;
	}
	public Deck getDeck() {
		return deck;
	}
	
	public Boolean isCommander() {
		return Boolean.valueOf(commander);
	}

}
