import { Component, OnInit } from '@angular/core';
import { CardsService } from '../cards.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cards-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {

  pseudo: string;

  constructor(private route: ActivatedRoute, private router: Router, private cardsService: CardsService) {

  }

  signIn() {
    this.cardsService.signIn(this.pseudo).subscribe(result => {
    	sessionStorage.setItem("mtgUser", JSON.stringify(result));
    	this.gotoHome();
    });
  }
  
  logIn() {
    this.cardsService.logIn(this.pseudo).subscribe(result => {
    	sessionStorage.setItem("mtgUser", JSON.stringify(result));
    	this.gotoHome();
    });
  }
 
  gotoHome() {
    this.router.navigate(['/']);
  }

}