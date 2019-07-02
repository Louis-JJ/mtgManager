import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { CardsListComponent } from './cards-list/cards-list.component';
import { CardsFormComponent } from './cards-form/cards-form.component';
import { HttpClientModule } from '@angular/common/http';
import { CardsService } from './cards.service';

@NgModule({
  declarations: [
    AppComponent,
    CardsListComponent,
    CardsFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CardsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
