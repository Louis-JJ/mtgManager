package fr.mtg.gestion.entities.nodes;



import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import fr.mtg.gestion.entities.relationships.OwnCard;

@NodeEntity
public class Card {

	@Id
    @GeneratedValue
    private Long id;
	
	private Long mtgId;
	private String nameFr;
	private String nameEn;
	private String cmc;
	private String type;
	private String flavorText;
	private String rarity;
	private String extension;
	private String power;
	private String toughness;
	private String colors;
	
	@Relationship(type = "OWN", direction = Relationship.INCOMING)
	   private List<OwnCard> ownBy;

	public Long getId() {
		return id;
	}
	
	public Long getMtgId() {
		return mtgId;
	}

	public String getNameFr() {
		return nameFr;
	}

	public String getNameEn() {
		return nameEn;
	}
	
	public String getCmc() {
		return cmc;
	}

	public String getType() {
		return type;
	}

	public String getFlavorText() {
		return flavorText;
	}

	public String getRarity() {
		return rarity;
	}

	public String getExtension() {
		return extension;
	}

	public String getPower() {
		return power;
	}

	public String getToughness() {
		return toughness;
	}

	public String getColors() {
		return colors;
	}
	
	public String toString() {
		return "Card [ id : "+this.id+", name : "+this.nameFr +" ]";
	}
}
