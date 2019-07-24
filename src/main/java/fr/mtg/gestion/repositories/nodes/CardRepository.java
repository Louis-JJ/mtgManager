package fr.mtg.gestion.repositories.nodes;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import fr.mtg.gestion.entities.nodes.Card;

public interface CardRepository extends Neo4jRepository<Card, Long> {
	
	Card findByMtgId(@Param("mtgId") Long mtgId);

	Card findByNameFr(@Param("nameFr") String name);
	
	Card findByNameEn(@Param("nameEn") String name);
	
	Collection<Card> findByFlavorText(@Param("flavorText") String tag);
	
	@Query("MATCH (card:Card)<-[own:OWN]-(u:User) WHERE ID(u) = {0} RETURN card,own.number")
	Iterable<Map<String,Object>> getUserCollection(Long userId);
	
	@Query("MATCH (card:Card)<-[own:OWN]-(u:User) WHERE ID(u) = {0} AND card.mtgId = {1} AND card.colors =~ {2} RETURN card,own.number")
	List<Map<String,Object>> getUserCardByMtgIdAndColors(Long userId, String searchQuery, String colorQuery);
	
	@Query("MATCH (card:Card)<-[own:OWN]-(u:User) WHERE ID(u) = {0} AND card.nameFr = {1} AND card.colors =~ {2} RETURN card,own.number")
	List<Map<String,Object>> getUserCardByNameFrAndColors(Long userId, String searchQuery, String colorQuery);
	
	@Query("MATCH (card:Card)<-[own:OWN]-(u:User) WHERE ID(u) = {0} AND card.nameEn = {1} AND card.colors =~ {2} RETURN card,own.number")
	List<Map<String,Object>> getUserCardByNameEnAndColors(Long userId, String searchQuery, String colorQuery);
	
	@Query("MATCH (d:Deck)-[c:CONTAIN]->(card:Card), (u:User)-[o:OWN]->(card) WHERE ID(u) = {0} AND ID(d) = {1} RETURN card,c.number,o.number")
	Iterable<Map<String,Object>> getDeckCards(Long userId, Long deckId);

}
