package fr.mtg.gestion.entities.requests;

import fr.mtg.gestion.entities.nodes.Deck;

public class UserDeckRequest {
	
	private long userId;
	private Deck deck;
	
	public long getUserId() {
		return userId;
	}
	
	public Deck getDeck() {
		return deck;
	}

}
