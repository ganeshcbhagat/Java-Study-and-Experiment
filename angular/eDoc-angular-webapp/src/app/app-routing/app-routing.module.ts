import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from '../app.component';
import { LoginComponent } from '../components/login/login.component';
import { AboutUsComponent } from '../components/about-us/about-us.component';
import { ContactUsComponent } from '../components/contact-us/contact-us.component';
import { FaqComponent } from '../components/faq/faq.component';
import { ForgotPasswordComponent } from '../components/forgot-password/forgot-password.component';
import { PasswordResetComponent } from '../components/password-reset/password-reset.component';
import { RegistrationComponent } from '../components/registration/registration.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'about-us',
    component: AboutUsComponent
  },
  {
    path: 'contact-us',
    component: ContactUsComponent
  },
  {
    path: 'faq',
    component: FaqComponent
  },
  {
    path: 'forgot-password',
    component: ForgotPasswordComponent
  },
  {
    path: 'password-reset',
    component: PasswordResetComponent
  },
  {
    path: 'registration',
    component: RegistrationComponent
  }
  ];

@NgModule({
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }