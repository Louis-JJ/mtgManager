package fr.mtg.gestion.entities.nodes;

import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import fr.mtg.gestion.entities.relationships.Commander;
import fr.mtg.gestion.entities.relationships.Contain;
import fr.mtg.gestion.entities.relationships.OwnCard;
import fr.mtg.gestion.entities.relationships.UseDeck;

@NodeEntity
public class Deck {
	
	@Id
    @GeneratedValue
    private Long id;
	
	private String name;
	private String colors;
	
	@Relationship(type = "CONTAIN")
	private List<Contain> cards;
	
	@Relationship(type = "COMMANDER")
	private List<Commander> commander;

}
