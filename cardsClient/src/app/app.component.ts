import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { hasUser, getUser } from './authent.utils';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string;
  hasUser;
  getUser;

  constructor(private router: Router){
    this.title = 'titleFromConstructor'
    this.hasUser = hasUser;
    this.getUser = getUser;
  }
  
  logOut(){
	  if(sessionStorage) {
		  sessionStorage.removeItem('mtgUser');
	  } this.router.navigate(['/']);
  }
  
}
