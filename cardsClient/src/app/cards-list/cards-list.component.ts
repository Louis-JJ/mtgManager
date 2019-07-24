import { Component, OnInit } from '@angular/core';
import { Card } from '../card';
import { CardsService } from '../cards.service';
import { hasUser, getUser } from '../authent.utils';

@Component({
  selector: 'app-cards-list',
  templateUrl: './cards-list.component.html',
  styleUrls: ['./cards-list.component.css']
})
export class CardsListComponent implements OnInit {

  cards: Card[];

  hasUser;

  constructor(private cardsService: CardsService) { 
	  this.hasUser = hasUser;
  }

  ngOnInit() {
	  
	  if(hasUser()) {
		  this.cardsService.findAllUserCards(getUser().id.toString()).subscribe(data => {
		      this.cards = data.map(dict => {
		    	  let card = dict["card"];
		    	  card.number = dict["own.number"];
		    	  return card;
		      });
		    });
	  } else {
		  this.cardsService.findAll().subscribe(data => {
		      this.cards = data;
		    });
	  }
  }

}
