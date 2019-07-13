package fr.mtg.gestion.repositories;

import java.util.Collection;
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

}
