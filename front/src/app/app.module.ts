import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { AsideComponent } from './components/aside/aside.component';
import { TopMessageComponent } from './components/top-message/top-message.component';
import ptBr from '@angular/common/locales/pt';
import { registerLocaleData } from '@angular/common';
import { FuelingTableComponent } from './components/fueling-table/fueling-table.component';
import { AlertMessageComponent } from './components/alert-message/alert-message.component';
import { PumpTableComponent } from './components/pump-table/pump-table.component';
import { TankTableComponent } from './components/tank-table/tank-table.component';
import { FuelingFormComponent } from './components/fueling-form/fueling-form.component';
import { CommonsComponent } from './components/commons/commons.component';

registerLocaleData(ptBr);

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    AsideComponent,
    TopMessageComponent,
    FuelingTableComponent,
    AlertMessageComponent,
    PumpTableComponent,
    TankTableComponent,
    FuelingFormComponent,
    CommonsComponent,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt' },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
