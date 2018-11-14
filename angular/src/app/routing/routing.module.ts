import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes, RouterModule} from '@angular/router';
import { EmployeeDashboardDummyComponent } from '../user-profile/employee-dashboard-smart/employee-dashboard-dummy/employee-dashboard-dummy.component';

export const appRoutes:Routes=[
  {
    path: "home/:id",
    component: EmployeeDashboardDummyComponent
  }

]


@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes),
    CommonModule
  ],
  declarations: [],
  exports: [RouterModule]
})
export class RoutingModule { }
