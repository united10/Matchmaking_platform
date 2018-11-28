import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeeDashboardDummyComponent } from './employee-dashboard-smart/employee-dashboard-dummy/employee-dashboard-dummy.component';
import { EmployeeDashboardSmartComponent } from './employee-dashboard-smart/employee-dashboard-smart.component';
import { BrowserModule } from '@angular/platform-browser';



import { MatGridListModule, MatCardModule, MatMenuModule, MatIconModule, MatButtonModule } from '@angular/material';
import { LayoutModule } from '@angular/cdk/layout';
import { RoutingModule } from '../routing/routing.module';
import {  HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CardComponent } from '../add-module/card/card.component';
import { CardsModule } from '../add-module/cards.module';
import { MaterialModule } from '../login/login-module/material.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    MatGridListModule,
    MatCardModule,
    MatIconModule,
    MatMenuModule,
    MatButtonModule,
    LayoutModule,
    CardsModule,
    MaterialModule,
    NgbModule
  ],
  declarations: [
    EmployeeDashboardDummyComponent,
    EmployeeDashboardSmartComponent,
]
})
export class UserProfileModule { }
