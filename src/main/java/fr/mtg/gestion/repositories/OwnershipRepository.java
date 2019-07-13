package fr.mtg.gestion.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import fr.mtg.gestion.entities.relationships.OwnCard;

public interface OwnershipRepository extends Neo4jRepository<OwnCard, Long> {
	
	@Query("MATCH (u:User)-[o:OWN]->(c:Card) WHERE ID(u) = {0} AND ID(c) = {1} RETURN o")
	public OwnCard find(Long userId, Long CardId);

}
