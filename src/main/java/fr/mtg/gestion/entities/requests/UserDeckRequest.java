package fr.mtg.gestion.entities.requests;

import fr.mtg.gestion.entities.nodes.Deck;

/**
 * 
 * Request object to map parameters in " <b>create deck for user</b> " operations.
 *
 */
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
