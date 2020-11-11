import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PageNotFoundComponent } from './shared/components/page-not-found/page-not-found.component';
import { AuthGuard } from './shared/guards/auth.guard';
import { TimelineComponent } from './timeline/timeline.component';
import { AnnouncementComponent } from './authentication/components/announcement/announcement.component';
import { HomepageComponent } from './authentication/components/homepage/homepage.component';
import { RegisterTimeSlotsComponent } from './match-making/components/register-time-slots/register-time-slots.component';
import { ViewTimeSlotsComponent } from './match-making/components/view-time-slots/view-time-slots.component';
const routes: Routes = [
  {
    path: '',
    redirectTo: 'authentication',
    pathMatch: 'full'
  },
  {
    path: 'authentication',
    loadChildren: () => import('./authentication/authentication.module').then(m => m.AuthenticationModule)
  },
  {
    path: 'announcement',
    component: AnnouncementComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'timeline',
    component:TimelineComponent,
  },
  {
    component: HomepageComponent,
    path: 'homepage',
    canActivate: [AuthGuard]
  },
  {
      component: RegisterTimeSlotsComponent,
      path: 'register-time-slots',
      canActivate: [AuthGuard]
  },
  {
        component: ViewTimeSlotsComponent,
        path: 'view-time-slots',
        canActivate: [AuthGuard]
  },
 {
    path: '**',
    component: PageNotFoundComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
