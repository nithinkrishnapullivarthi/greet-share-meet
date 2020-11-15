import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from "./home.component";
import { AddeditinterestsComponent } from "./components/addeditinterests/addeditinterests.component";
import { EditprofileComponent } from "./components/editprofile/editprofile.component";

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    children: [
      {
        path: 'addeditinterests',
        component: AddeditinterestsComponent
      },
      {
        path: 'editprofile',
        component: EditprofileComponent
      },
      /* {
         path: '',
         redirectTo: 'editprofile',
         pathMatch: 'full'
       }*/
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
