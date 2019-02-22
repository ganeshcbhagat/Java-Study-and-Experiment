import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { SharedModule } from '../shared/Shared.module';
import { AuthenticationRoutingModule } from './authentication-routing.module';
import { ComponentsModule } from './components/components.module';
import { ServicesModule } from './services/services.module';

@NgModule({
  imports: [SharedModule, CommonModule, FormsModule, RouterModule, ComponentsModule, ServicesModule, AuthenticationRoutingModule,],
  declarations: [],
  exports: [ComponentsModule, ServicesModule, AuthenticationRoutingModule]
})
export class AuthenticationModule { }
