import { Component, OnInit } from '@angular/core';
import { Card } from '../card';
import { Deck } from '../deck';
import { CardsService } from '../cards.service';
import { hasUser, getUser } from '../authent.utils';
import { Router, ActivatedRoute } from '@angular/router';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-cards-form',
  templateUrl: './deck-edit-form.component.html',
  styleUrls: ['./deck-edit-form.component.css']
})
export class DeckEditFormComponent {
	
  loadDecksControl = new FormControl();
  hasUser;
  
  deck: Deck;
  deckCardsData: [];

  loadedDecks: Deck[];
  
  searchType: string;
  searchText: string;
  
  candidateCard: Card;
  candidateCardMaxNumber: number;
  candidateCardNumber: number;
  isCommander: boolean;

  constructor(private route: ActivatedRoute, private router: Router, private cardsService: CardsService) {
	  this.hasUser = hasUser;
	  
	  this.deck = undefined;
	  
	  this.cardsService.findUserDecks(getUser().id).subscribe(result => {
		  this.loadedDecks = result;
		  this.loadDecksControl.valueChanges.subscribe(value => this.getDeckCards(value));
	  });
	  
	  this.searchType="mtgId";
	  
	  this.isCommander = false;

  }
  
  getDeckSize() {
	  return this.deck && this.deckCardsData ? 
			  this.deckCardsData.map(data => data["c.number"])
			  .reduce((a, b) => a + b, 0) : 0;
  }
  
  hasDeck() {
	  return this.deck != undefined;
  }
  
  onSearch() {
	  this.cardsService.findUserCardWithColors(getUser().id, this.searchText, this.searchType, this.deck.colors)
	  .subscribe(result => {
		  if(result !== undefined){
			  const data: {} = result.shift();
			  this.candidateCard = data["card"];
			  this.candidateCardMaxNumber = Math.min(4, data["own.number"]);
		  }
	  });
  }
  
  onAdd() {
	  this.cardsService.addCardToDeck(this.candidateCard, this.candidateCardNumber, this.isCommander.toString(), this.deck)
	  .subscribe(result => {
		  this.candidateCard = null;
		  this.candidateCardMaxNumber = null;
		  this.candidateCardNumber = null;
		  this.isCommander = false;
		  this.getDeckCards(this.deck);
	  });
  }
 
  getDeckCards(deck: Deck) {
	  if(deck && hasUser()){
		  this.cardsService.findDeckCards(getUser().id, deck.id)
		  .subscribe(result => {
			  this.deckCardsData=result;
		  });
	  }
  }

}