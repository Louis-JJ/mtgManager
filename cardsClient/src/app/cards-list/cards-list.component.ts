import { Component, OnInit } from '@angular/core';
import { Card } from '../card';
import { CardsService } from '../cards.service';

@Component({
  selector: 'app-cards-list',
  templateUrl: './cards-list.component.html',
  styleUrls: ['./cards-list.component.css']
})
export class CardsListComponent implements OnInit {

  cards: Card[];

  constructor(private cardsService: CardsService) { }

  ngOnInit() {
	  
	  if(this.asUser()) {
		  this.cardsService.findAllUserCards(this.getUser().id.toString()).subscribe(data => {
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
  
  asUser() {
	  return sessionStorage && sessionStorage.getItem('mtgUser');
  }
  
  getUser() {
	  return JSON.parse(sessionStorage.getItem('mtgUser'));
  }

}
