import { Component, OnInit } from '@angular/core';
import { Cards } from '../cards';
import { CardsService } from '../cards.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cards-form',
  templateUrl: './cards-form.component.html',
  styleUrls: ['./cards-form.component.css']
})
export class CardsFormComponent {

  cards: Cards;

  constructor(private route: ActivatedRoute, private router: Router, private cardsService: CardsService) {
    this.cards = new Cards();
  }

  onSubmit() {
    this.cardsService.save(this.cards).subscribe(result => this.gotoCardsList());
  }
 
  gotoCardsList() {
    this.router.navigate(['/cards']);
  }

}
