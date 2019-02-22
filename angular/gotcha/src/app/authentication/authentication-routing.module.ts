import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { PasswordForgotComponent } from './components/password-forgot/password-forgot.component';
import { PasswordResetComponent } from './components/password-reset/password-reset.component';
import { RegistrationComponent } from './components/registration/registration.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'password-forgot', component: PasswordForgotComponent },
  { path: 'password-reset', component: PasswordResetComponent },
  { path: 'registration', component: RegistrationComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthenticationRoutingModule { }
