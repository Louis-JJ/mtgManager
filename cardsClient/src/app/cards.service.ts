import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Cards } from './cards';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CardsService {

  private cardsUrl: string;

  constructor(private http: HttpClient) {
    this.cardsUrl = 'http://localhost:8080/cards';
  }

  public findAll(): Observable<Cards[]> {
    return this.http.get<Cards[]>(this.cardsUrl);
  }

  public save(card: Cards) {
    return this.http.post<Cards>(this.cardsUrl, card);
  }
}
