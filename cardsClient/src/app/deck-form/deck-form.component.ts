import { Component, OnInit } from '@angular/core';
import { Card } from '../card';
import { Deck } from '../deck';
import { CardsService } from '../cards.service';
import { hasUser, getUser } from '../authent.utils';
import { Router, ActivatedRoute } from '@angular/router';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-cards-form',
  templateUrl: './deck-form.component.html',
  styleUrls: ['./deck-form.component.css']
})
export class DeckFormComponent {
	
  hasUser;

  deckName: string;
  red: boolean;
  green: boolean;
  blue: boolean;
  white: boolean;
  black: boolean;

  isCommander: boolean;

  constructor(private route: ActivatedRoute, private router: Router, private cardsService: CardsService) {
	  
	  this.red = false;
	  this.green = false;
	  this.blue = false;
	  this.white = false;
	  this.black = false;
	  
	  this.hasUser = hasUser;

  }
  
  getColorsString() {
	 if(!(this.red || this.green || this.blue || this.white || this.black)) {
		 return "{}";
	 }
	 let res = "";
	 if(this.red){
		 res += "{R}";	 
	 }
	 if(this.green){
		 res += "{G}";	 
	 }
	 if(this.blue){
		 res += "{U}";	 
	 }
	 if(this.white){
		 res += "{W}";	 
	 }
	 if(this.black){
		 res += "{B}";	 
	 }
	 return res;
  }
  
  onSubmit() {
	  let newDeck = new Deck();
	  newDeck.name = this.deckName;
	  newDeck.colors = this.getColorsString();
	  this.cardsService.saveUserDeck(getUser().id, newDeck).subscribe(result => this.goToDeckEditor());
  }
 
  goToDeckEditor() {
    this.router.navigate(['/editdeck']);
  }

}