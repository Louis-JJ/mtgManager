package fr.mtg.gestion.repositories.nodes;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import fr.mtg.gestion.entities.nodes.Deck;
import fr.mtg.gestion.entities.relationships.Contain;

public interface DeckRepository extends Neo4jRepository<Deck, Long> {
	
	@Query("MATCH (deck:Deck)<-[use:USE]-(u:User) WHERE ID(u) = {0} RETURN deck")
	List<Deck> getUserDecks(Long userId);

}
