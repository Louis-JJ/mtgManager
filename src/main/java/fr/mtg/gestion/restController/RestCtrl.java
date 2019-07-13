package fr.mtg.gestion.restController;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.mtg.gestion.entities.nodes.Card;
import fr.mtg.gestion.entities.nodes.User;
import fr.mtg.gestion.entities.requests.UserCardRequest;
import fr.mtg.gestion.services.CardService;
import fr.mtg.gestion.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestCtrl {

	private final UserService userService;
	private final CardService cardService;

	public RestCtrl(UserService userService, CardService cardService) {
		super();
		this.userService = userService;
		this.cardService = cardService;
	}
	
	@PostMapping("/signin")
	public User signIn(@RequestBody String pseudo) {
		return userService.signIn(pseudo);
	}
	
	@PostMapping("/login")
	public User logIn(@RequestBody String pseudo) {
		return userService.logIn(pseudo);
	}
	
	@GetMapping("/cards")
	public List<Card> getCards() {
		return (List<Card>) cardService.findAllCards();
	}
	
	@PostMapping("/addcard")
	void addCard(@RequestBody Card card) {
		cardService.addCard(card);
	}
	
	@GetMapping("/usercards")
	public Iterable<Map<String,Object>> getUserCards(@RequestParam Long userId) {
		return cardService.findUserCards(userId);
	}
	
	@PostMapping("/addusercard")
	void addCard(@RequestBody UserCardRequest request) {
		cardService.addUserCard(request.getUserId(), request.getCard(), request.getNumber());
	}
	
}
