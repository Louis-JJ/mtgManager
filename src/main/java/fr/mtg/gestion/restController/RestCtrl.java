package fr.mtg.gestion.restController;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.mtg.gestion.cardsrepo.CardsRepository;
import fr.mtg.gestion.entities.Cards;
import fr.mtg.gestion.services.CardService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestCtrl {

	private final CardService cardService;

	public RestCtrl(CardService cardService) {
		super();
		this.cardService = cardService;
	}
	
	@GetMapping("/cards")
	public List<Cards> getCards() {
		return (List<Cards>) cardService.findAll();
		}
	
	@PostMapping("/cards")
	void addCard(@RequestBody Cards card) {
		cardService.addCard(card);
	}
	
}
