import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { FoundComponent } from './found/found.component';
import { LostComponent } from './lost/lost.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'found', component: FoundComponent },
  { path: 'lost', component: LostComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FeaturesRoutingModule { }
