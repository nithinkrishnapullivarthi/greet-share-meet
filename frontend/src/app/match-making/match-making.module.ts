
import { CommonModule } from '@angular/common'
import { NgModule } from '@angular/core';
import { MatchMakingRoutingModule } from './match-making-routing.module'
import { ViewTimeSlotsComponent } from './components/view-time-slots/view-time-slots.component'
import { MatchMakingComponent } from './match-making.component'
import { SharedModule } from '../shared/shared.module'
import {RegisterTimeSlotsComponent} from './components/register-time-slots/register-time-slots.component'

@NgModule({
  declarations: [MatchMakingComponent, ViewTimeSlotsComponent,RegisterTimeSlotsComponent],
  imports: [
    CommonModule,
    MatchMakingRoutingModule,
    SharedModule, 
   ],
})
export class MatchMakingModule { }
