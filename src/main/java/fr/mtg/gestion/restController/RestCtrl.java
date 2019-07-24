package fr.mtg.gestion.restController;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.mtg.gestion.cardsrepo.CardsRepository;
import fr.mtg.gestion.entities.Cards;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestCtrl {

	private final CardsRepository cardsRepo;

	public RestCtrl(CardsRepository cardsRepo) {
		super();
		this.cardsRepo = cardsRepo;
	}
	
	@GetMapping("/cards")
	public List<Cards> getCards() {
		return (List<Cards>) cardsRepo.findAll();
		}
	
	@PostMapping("/cards")
	void addCard(@RequestBody Cards card) {
		cardsRepo.save(card);
	}
	
}
