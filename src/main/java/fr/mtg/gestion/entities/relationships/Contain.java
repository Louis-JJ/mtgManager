package fr.mtg.gestion.entities.relationships;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import fr.mtg.gestion.entities.nodes.Card;
import fr.mtg.gestion.entities.nodes.Deck;

@RelationshipEntity(type = "CONTAIN")
public class Contain {

	@Id @GeneratedValue 
	private Long id;
	
	private Long number;
	
	@StartNode
	private Deck deck;
	
	@EndNode
	private Card card;
	
	public Contain(Card card, Long number, Deck deck) {
		this.card = card;
		this.number = number;
		this.deck = deck;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

}
