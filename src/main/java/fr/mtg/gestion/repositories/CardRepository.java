package fr.mtg.gestion.cardsrepo;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import fr.mtg.gestion.entities.Cards;

public interface CardsRepository extends Neo4jRepository<Cards, Long> {

	@Query("CREATE (card: {0})")
	void addcard(Cards card);

}
