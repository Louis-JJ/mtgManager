import { Component, OnInit } from '@angular/core';
import { Cards } from '../cards';
import { CardsService } from '../cards.service';

@Component({
  selector: 'app-cards-list',
  templateUrl: './cards-list.component.html',
  styleUrls: ['./cards-list.component.css']
})
export class CardsListComponent implements OnInit {

  cards: Cards[];

  constructor(private cardsService: CardsService) { }

  ngOnInit() {
    this.cardsService.findAll().subscribe(data => {
      this.cards = data;
    });
  }

}
