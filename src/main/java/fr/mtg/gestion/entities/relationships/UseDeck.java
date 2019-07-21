package fr.mtg.gestion.entities.relationships;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import fr.mtg.gestion.entities.nodes.Deck;
import fr.mtg.gestion.entities.nodes.User;

@RelationshipEntity(type = "USE")
public class UseDeck {
	
	@Id @GeneratedValue private Long id;
	
	@StartNode
	private User user;
	
	@EndNode
	private Deck deck;
	
	public UseDeck(User user, Deck deck) {
		this.user = user;
		this.deck = deck;
	}

}
