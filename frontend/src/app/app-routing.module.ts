import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PageNotFoundComponent } from './shared/components/page-not-found/page-not-found.component';
import { AuthGuard } from './shared/guards/auth.guard';
import { TimelineComponent } from './timeline/timeline.component';
import { AnnouncementComponent } from './authentication/components/announcement/announcement.component';
import { HomepageComponent } from './authentication/components/homepage/homepage.component';
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
    path: 'matchmaking',
    loadChildren: () => import('./match-making/match-making.module').then(m => m.MatchMakingModule),
    canActivate: [AuthGuard]
  
  },
  {
    path: 'announcements',
    component:TimelineComponent,
    canActivate: [AuthGuard]
  },
  {
    component: HomepageComponent,
    path: 'homepage',
    canActivate: [AuthGuard]
  },
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then(m => m.HomeModule),
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
