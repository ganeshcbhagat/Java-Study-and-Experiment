import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { SharedModule } from '../shared/Shared.module';

import { FeaturesRoutingModule } from './features-routing.module';
import { HomeComponent } from './home/home.component';
import { FoundComponent } from './found/found.component';
import { LostComponent } from './lost/lost.component';

@NgModule({
  imports: [CommonModule, NgbModule, SharedModule, FeaturesRoutingModule],
  declarations: [HomeComponent, FoundComponent, LostComponent],
  exports: [FeaturesRoutingModule, HomeComponent, FoundComponent, LostComponent]
})
export class FeaturesModule { }
