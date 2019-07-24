package fr.mtg.gestion.cardsrepo;

import org.springframework.data.repository.CrudRepository;

import fr.mtg.gestion.entities.Cards;

public interface CardsRepository extends CrudRepository<Cards, Long> {

}
