import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from  '@angular/common/http';
import { AppRoutingModule } from  './app-routing/app-routing.module';
import { APP_BASE_HREF } from '@angular/common';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { FaqComponent } from './components/faq/faq.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { PasswordResetComponent } from './components/password-reset/password-reset.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginService } from './services/login.service';
import { RegistrationService } from './services/registration.service';

@NgModule({
  imports:      [ BrowserModule, FormsModule, HttpClientModule, AppRoutingModule ],
  declarations: [ AppComponent, LoginComponent, AboutUsComponent, ContactUsComponent, FaqComponent, ForgotPasswordComponent, PasswordResetComponent, RegistrationComponent, HeaderComponent, FooterComponent ],
  providers: [{provide: APP_BASE_HREF, useValue: '/'}, LoginService, RegistrationService],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
