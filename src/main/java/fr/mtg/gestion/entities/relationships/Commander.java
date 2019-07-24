package fr.mtg.gestion.entities.relationships;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import fr.mtg.gestion.entities.nodes.Card;
import fr.mtg.gestion.entities.nodes.Deck;

@RelationshipEntity(type = "COMMANDER")
public class Commander {

	@Id @GeneratedValue private Long id;
	
	@StartNode
	private Deck deck;
	
	@EndNode
	private Card card;
	
	public Commander(Deck deck, Card card) {
		this.deck = deck;
		this.card = card;
	}

}
