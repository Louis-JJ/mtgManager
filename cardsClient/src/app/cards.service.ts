import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Card } from './card';
import { Deck } from './deck';
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
  
  public saveUserDeck(userId: string, deck: Deck): Observable<Deck> {
	  return this.http.post<Deck>(this.backendUrl + '/adduserdeck', {'userId': userId, 'deck': deck});
  }
  
  public findUserDecks(userId: string): Observable<[]> {
	  let options = { params: new HttpParams().set('userId', userId) };
	  return this.http.get<[]>(this.backendUrl + '/userdecks', options);
  }
  
  public findUserCardWithColors(userId: string, searchText: string, searchType: string, colors: string): Observable<[]> {
	  let options = { params: new HttpParams().set('userId', userId).set('searchType', searchType)
			  .set('searchText', searchText).set('colors', colors)};
	  return this.http.get<[]>(this.backendUrl + "/usercardwithcolors", options);  
  }
  
  public addCardToDeck(card: Card, cardNumber: number, isCommander: string, deck: Deck) {
	  return this.http.post(this.backendUrl + '/addcardtodeck', {'card': card, 'number': cardNumber, 'commander': isCommander, 'deck': deck});
  }
  
  public findDeckCards(userId: string, deckId: string): Observable<[]> {
	  let options = { params: new HttpParams().set('userId', userId).set('deckId', deckId) };
	  return this.http.get<[]>(this.backendUrl + '/deckcards', options);
  }
}
