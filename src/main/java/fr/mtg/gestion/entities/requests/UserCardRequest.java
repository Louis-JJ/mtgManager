package fr.mtg.gestion.entities.requests;

import fr.mtg.gestion.entities.nodes.Card;

public class UserCardRequest {
	
	private long userId;
	private Card card;
	private short number;
	
	public long getUserId() {
		return userId;
	}
	public Card getCard() {
		return card;
	}
	public short getNumber() {
		return number;
	}
	
}
