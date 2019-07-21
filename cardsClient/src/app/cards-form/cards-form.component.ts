import { Component, OnInit } from '@angular/core';
import { Card } from '../card';
import { CardsService } from '../cards.service';
import { hasUser, getUser } from '../authent.utils';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cards-form',
  templateUrl: './cards-form.component.html',
  styleUrls: ['./cards-form.component.css']
})
export class CardsFormComponent {

  card: Card;
  numberCard: number;

  red: boolean;
  green: boolean;
  blue: boolean;
  white: boolean;
  black: boolean;

  constructor(private route: ActivatedRoute, private router: Router, private cardsService: CardsService) {
    this.card = new Card();
    this.numberCard = 1;
    
    this.red = false;
	  this.green = false;
	  this.blue = false;
	  this.white = false;
	  this.black = false;
  }

  onSubmit() {
	  this.card.colors = this.getColorsString();
	  if(hasUser()) {
		  this.cardsService.saveUserCard(getUser().id, this.card, this.numberCard).subscribe(result => this.gotoCardsList());
	  }else {
		  this.cardsService.save(this.card).subscribe(result => this.gotoCardsList());
	  }
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
 
  gotoCardsList() {
    this.router.navigate(['/cards']);
  }

}
