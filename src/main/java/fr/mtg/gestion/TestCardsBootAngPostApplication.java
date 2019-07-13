package fr.mtg.gestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("fr.mtg.gestion.repositories")
public class TestCardsBootAngPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestCardsBootAngPostApplication.class, args);
	}

}
