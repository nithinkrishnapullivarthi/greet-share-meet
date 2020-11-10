import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterTimeSlotsComponent } from './components/register-time-slots/register-time-slots.component';
import { ViewTimeSlotsComponent } from './components/view-time-slots/view-time-slots.component';
import { MatchMakingComponent } from './match-making.component';

const routes: Routes = [

  {
    path:'',
    component: MatchMakingComponent,
    children:[
      {
        path:'registertimeslots',
        component:RegisterTimeSlotsComponent
      },
      {
        path:'viewtimeslots',
        component:ViewTimeSlotsComponent
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MatchMakingRoutingModule { }
