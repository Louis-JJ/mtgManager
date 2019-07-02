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
	
	private final String name;

	public Cards(String name) {
		super();
		this.name = name;
	}

	public Cards() {
		super();
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
	
	public String toString() {
		return "Card [ id : "+this.id+", name : "+this.name+" ]";
	}
}
