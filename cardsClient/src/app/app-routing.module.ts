import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CardsListComponent } from './cards-list/cards-list.component';
import { CardsFormComponent } from './cards-form/cards-form.component';

const routes: Routes = [
  { path: 'cards', component: CardsListComponent },
  { path: 'addcard', component: CardsFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
