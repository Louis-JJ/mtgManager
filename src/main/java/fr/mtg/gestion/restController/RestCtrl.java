package fr.mtg.gestion.restController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.mtg.gestion.entities.nodes.Card;
import fr.mtg.gestion.entities.nodes.Deck;
import fr.mtg.gestion.entities.nodes.User;
import fr.mtg.gestion.entities.relationships.Contain;
import fr.mtg.gestion.entities.requests.CardDeckRequest;
import fr.mtg.gestion.entities.requests.UserCardRequest;
import fr.mtg.gestion.entities.requests.UserDeckRequest;
import fr.mtg.gestion.services.CardService;
import fr.mtg.gestion.services.DeckService;
import fr.mtg.gestion.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestCtrl {

	private final UserService userService;
	private final CardService cardService;
	private final DeckService deckService;

	public RestCtrl(UserService userService, CardService cardService, DeckService deckService) {
		super();
		this.userService = userService;
		this.cardService = cardService;
		this.deckService = deckService;
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
	
	@GetMapping("/userdecks")
	public List<Deck> getUserDecks(@RequestParam Long userId) {
		return deckService.findUserDecks(userId);
	}
	
	@PostMapping("/adduserdeck")
	public Deck addDeck(@RequestBody UserDeckRequest request) {
		return deckService.addUserDeck(request.getUserId(), request.getDeck());
	}
	
	@GetMapping("/usercardwithcolors")
	public List<Map<String,Object>> getUserCardWithColors(@RequestParam Long userId, @RequestParam String searchType, String searchText, @RequestParam String colors) {
		return cardService.findUserCardWithColors(userId, searchType, searchText, colors);
	}
	
	@GetMapping("/deckcards")
	public List<Map<String, Object>> getDeckCards(@RequestParam Long userId, @RequestParam Long deckId) {
		return cardService.findDeckCards(userId, deckId);
	}
	
	@PostMapping("/addcardtodeck")
	public ResponseEntity<HttpStatus> addCardToDeck(@RequestBody CardDeckRequest request) {
		deckService.addCardToDeck(request.getCard(), request.getNumber(), request.getDeck());
		if(request.isCommander()) {
			deckService.addCommanderToDeck(request.getCard(), request.getDeck());
		} return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
}
