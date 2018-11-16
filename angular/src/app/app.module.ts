import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CardsModule } from './cards/cards.module';
import { EducationService } from './cards/service/education.service';
import { HttpClientModule } from '@angular/common/http';
import { RoutingModule } from './routing/routing.module';
import { UserProfileModule } from './user-profile/user-profile.module';
import { LoginModule } from './login/login/login.module';
import { SignUpModule } from './register/sign-up/sign-up.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RoutingModule,
    UserProfileModule,
    LoginModule,
    SignUpModule
  ],
  providers: [EducationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
