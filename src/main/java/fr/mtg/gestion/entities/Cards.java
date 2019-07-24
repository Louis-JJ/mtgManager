package fr.mtg.gestion.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cards {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	private String name;
	private String mana_cost;
	private String type;
	private String text;
	private String rarity;
	private String power;
	private String toughness;
	private String colors;
	private int number;
	
	public Cards(String name, String mana_cost, String type, String text, String rarity, String power, String toughness,
			String colors, int number) {
		super();
		this.name = name;
		this.mana_cost = mana_cost;
		this.type = type;
		this.text = text;
		this.rarity = rarity;
		this.power = power;
		this.toughness = toughness;
		this.colors = colors;
		this.number = number;
	}

	public Cards(String name) {
		this.name = name;
	}

	public Cards() {
		this.name = null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMana_cost() {
		return mana_cost;
	}

	public void setMana_cost(String mana_cost) {
		this.mana_cost = mana_cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getToughness() {
		return toughness;
	}

	public void setToughness(String toughness) {
		this.toughness = toughness;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String toString() {
		return "Card [ id : "+this.id+", name : "+this.name+" ]";
	}
}
