package fr.mtg.gestion.entities.relationships;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import fr.mtg.gestion.entities.nodes.Card;
import fr.mtg.gestion.entities.nodes.User;

@RelationshipEntity(type = "OWN")
public class OwnCard {
	
	@Id @GeneratedValue 
	private Long id;
	
	private long number;
	
	@StartNode
	private User user;
	
	@EndNode
	private Card card;
	
	public OwnCard(User user, Card card, long number) {
		this.user = user;
		this.card = card;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public long getNumber() {
		return number;
	}
	
	public void setNumber(long number) {
		this.number = number;
	}

	public User getUser() {
		return user;
	}

	public Card getCard() {
		return card;
	}

}
