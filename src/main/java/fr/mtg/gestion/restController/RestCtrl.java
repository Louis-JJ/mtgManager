package fr.mtg.gestion.restController;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.mtg.gestion.entities.nodes.Card;
import fr.mtg.gestion.repositories.CardRepository;
import fr.mtg.gestion.services.CardService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestCtrl {

	private final CardService mtgService;

	public RestCtrl(CardService mtgService) {
		super();
		this.mtgService = mtgService;
	}
	
	@GetMapping("/cards")
	public List<Card> getCards() {
		return (List<Card>) mtgService.findAllCards();
	}
	
	@PostMapping("/addcard")
	void addCard(@RequestBody Card card) {
		mtgService.addCard(card);
	}
	
	@GetMapping("/usercards")
	public List<Card> getUserCards(@RequestBody Long userId) {
		return (List<Card>) mtgService.findUserCards(userId);
	}
	
	@PostMapping("/addusercard")
	void addCard(@RequestBody Long userId, @RequestBody Card card, @RequestBody short number) {
		mtgService.addUserCard(userId, card, number);
	}
	
}
