import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AnnouncementComponent } from '../authentication/components/announcement/announcement.component';

const routes: Routes = [
  {
    path: 'announcement',
    component: AnnouncementComponent
    //canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
