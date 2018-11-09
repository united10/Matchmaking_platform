import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CardsModule } from './cards/cards.module';
import { EducationService } from './cards/service/education.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    CardsModule,
    HttpClientModule
  ],
  providers: [EducationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
