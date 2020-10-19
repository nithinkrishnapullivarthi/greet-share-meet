import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
<<<<<<< HEAD
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
=======
import { AnnouncementComponent } from '../authentication/components/announcement/announcement.component';

const routes: Routes = [
  {
    path: 'announcement',
    component: AnnouncementComponent
    //canActivate: [AuthGuard]
>>>>>>> incomplete navigation and home
  }
];

@NgModule({
  imports: [RouterModule],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
