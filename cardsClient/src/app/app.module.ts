import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { UserFormComponent } from './user-form/user-form.component';
import { CardsListComponent } from './cards-list/cards-list.component';
import { CardsFormComponent } from './cards-form/cards-form.component';
import { DeckFormComponent } from './deck-form/deck-form.component';
import { DeckEditFormComponent } from './deck-edit-form/deck-edit-form.component';
import { HttpClientModule } from '@angular/common/http';
import { CardsService } from './cards.service';

@NgModule({
  declarations: [
    AppComponent,
    UserFormComponent,
    CardsListComponent,
    CardsFormComponent,
    DeckFormComponent,
    DeckEditFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [CardsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
