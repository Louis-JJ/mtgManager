import { Component, OnInit } from '@angular/core';
import { Card } from '../card';
import { CardsService } from '../cards.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cards-form',
  templateUrl: './cards-form.component.html',
  styleUrls: ['./cards-form.component.css']
})
export class CardsFormComponent {

  card: Card;
  numberCard: number;

  constructor(private route: ActivatedRoute, private router: Router, private cardsService: CardsService) {
    this.card = new Card();
    this.numberCard = 1;
  }

  onSubmit() {
	  if(this.asUser()) {
		  this.cardsService.saveUserCard(this.getUser().id, this.card, this.numberCard).subscribe(result => this.gotoCardsList());
	  }else {
		  this.cardsService.save(this.card).subscribe(result => this.gotoCardsList());
	  }
  }
 
  gotoCardsList() {
    this.router.navigate(['/cards']);
  }
  
  asUser() {
	  return sessionStorage && sessionStorage.getItem('mtgUser');
  }
  
  getUser() {
	  return JSON.parse(sessionStorage.getItem('mtgUser'));
  }

}
