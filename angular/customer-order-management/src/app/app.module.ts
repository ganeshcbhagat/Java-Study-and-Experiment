import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { APP_BASE_HREF } from '@angular/common';

import { CoreModule } from './core/core.module';
import { SharedModule } from './shared/shared.module';
import { CustomersModule } from './customers/customers.module';
import { AppComponent }  from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { OrdersModule } from './orders/orders.module';

@NgModule({
  imports:      [ BrowserModule, CustomersModule, OrdersModule, SharedModule, CoreModule, AppRoutingModule ],
  declarations: [ AppComponent ],
  providers: [{provide: APP_BASE_HREF, useValue: '/'}],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }