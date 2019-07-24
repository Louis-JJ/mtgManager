package fr.mtg.gestion.repositories.relationships;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import fr.mtg.gestion.entities.relationships.Commander;

public interface CommanderRepository  extends Neo4jRepository<Commander, Long> {

	@Query("MATCH (d:Deck)-[commander:COMMANDER]->(c:card) WHERE ID(d) = {0} AND ID(c) = {1} RETURN commander")
	Commander find(Long deckId, Long CardId);

}
