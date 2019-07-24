import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserFormComponent } from './user-form/user-form.component';
import { CardsListComponent } from './cards-list/cards-list.component';
import { CardsFormComponent } from './cards-form/cards-form.component';
import { DeckFormComponent } from './deck-form/deck-form.component';
import { DeckEditFormComponent } from './deck-edit-form/deck-edit-form.component';

const routes: Routes = [
  { path: 'auth', component: UserFormComponent },
  { path: 'cards', component: CardsListComponent },
  { path: 'addcard', component: CardsFormComponent },
  { path: 'adddeck', component: DeckFormComponent },
  { path: 'editdeck', component: DeckEditFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
