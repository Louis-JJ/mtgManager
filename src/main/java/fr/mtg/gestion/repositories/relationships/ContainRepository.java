package fr.mtg.gestion.repositories.relationships;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import fr.mtg.gestion.entities.relationships.Contain;

public interface ContainRepository extends Neo4jRepository<Contain, Long> {

	@Query("MATCH p=(d:Deck)-[r:CONTAIN]->(c:Card) WHERE ID(c) = {0} AND ID(d) = {1} RETURN p")
	Contain find(Long cardId, Long deckId);

}
