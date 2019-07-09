package fr.mtg.gestion.entities.nodes;

import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import fr.mtg.gestion.entities.relationships.OwnCard;
import fr.mtg.gestion.entities.relationships.UseDeck;

@NodeEntity
public class User {
	
	@Id
    @GeneratedValue
    private Long id;
	
	private String pseudo;
	
	@Relationship(type = "OWN")
	private List<OwnCard> cards;
	
	@Relationship(type = "USE")
	private List<UseDeck> decks;

	public Long getId() {
		return id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public List<OwnCard> getCards() {
		return cards;
	}

	public List<UseDeck> getDecks() {
		return decks;
	}	

}
