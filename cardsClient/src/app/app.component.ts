import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string;

  constructor(private router: Router){
    this.title = 'titleFromConstructor'
  }
  
  asUser(){
	  return sessionStorage && sessionStorage.getItem('mtgUser');
  }
  
  getUser(){
	  return JSON.parse(sessionStorage.getItem('mtgUser'));
  }
  
  logOut(){
	  if(sessionStorage) {
		  sessionStorage.removeItem('mtgUser');
	  } this.router.navigate(['/']);
  }
  
}
