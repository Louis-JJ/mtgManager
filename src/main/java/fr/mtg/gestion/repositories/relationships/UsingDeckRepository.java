package fr.mtg.gestion.repositories.relationships;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import fr.mtg.gestion.entities.relationships.UseDeck;

public interface UsingDeckRepository extends Neo4jRepository<UseDeck, Long> {
	
	@Query("MATCH (u:User)-[use:USE]->(d:DECK) WHERE ID(u) = {0} AND ID(d) = {1} RETURN count(use)>0 AS use")
	public boolean exist(Long userId, Long deckId);

}
