package fr.mtg.gestion.repositories.nodes;

import java.util.Collection;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import fr.mtg.gestion.entities.nodes.User;

public interface UserRepository extends Neo4jRepository<User, Long> {
	
	public Collection<User> findByPseudo(@Param("pseudo") String pseudo);

}
