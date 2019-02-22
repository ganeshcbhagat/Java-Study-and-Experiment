import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { PasswordResetComponent } from './password-reset/password-reset.component';
import { PasswordForgotComponent } from './password-forgot/password-forgot.component';

@NgModule({
  imports: [CommonModule, FormsModule, RouterModule, NgbModule],
  declarations: [LoginComponent, RegistrationComponent, PasswordResetComponent, PasswordForgotComponent],
  exports: [LoginComponent, RegistrationComponent, PasswordResetComponent, PasswordForgotComponent],
  providers : []
})
export class ComponentsModule { }
