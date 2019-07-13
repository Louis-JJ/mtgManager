import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Card } from './card';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CardsService {

  private backendUrl: string;

  constructor(private http: HttpClient) {
    this.backendUrl = 'http://localhost:8080';
  }
  
  public signIn(pseudo: string) {
	  return this.http.post<string>(this.backendUrl + '/signin', pseudo);
  }
  
  public logIn(pseudo: string) {
	  return this.http.post<string>(this.backendUrl + '/login', pseudo);
  }

  public findAll(): Observable<Card[]> {
    return this.http.get<Card[]>(this.backendUrl + '/cards');
  }

  public save(card: Card) {
    return this.http.post<Card>(this.backendUrl + '/addcard', card);
  }
  
  public findAllUserCards(userId: string): Observable<Card[]> {
	let options = { params: new HttpParams().set('userId', userId) };
    return this.http.get<[]>(this.backendUrl + '/usercards', options);
  }

  public saveUserCard(userId: string, card: Card, numberCard: number) {
    return this.http.post(this.backendUrl + '/addusercard', {'userId': userId, 'card': card, 'number': numberCard});
  }
}
