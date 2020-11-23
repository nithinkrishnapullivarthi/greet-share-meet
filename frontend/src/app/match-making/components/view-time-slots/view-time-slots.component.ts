import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HomeService } from '../../../home/services/home.service';


@Component({
  selector: 'app-view-time-slots',
  templateUrl: './view-time-slots.component.html',
  styleUrls: ['./view-time-slots.component.scss']
})
export class ViewTimeSlotsComponent implements OnInit {

  constructor(private homeService: HomeService,
    private fb: FormBuilder,
    private router: Router, ) {

    }

  UserDetails: string;
  errorMessage = null;
  public usercards: any;
   public userJson: any =[];

    ngOnInit(): void {

  let user = sessionStorage.getItem('user');
  this.userJson = JSON.parse(user);
  console.log('this is userjson',this.userJson.id);
      this.homeService.getUserTimeSlot().subscribe(res => {
         if(res){
          this.errorMessage = "No matching slots found";
         this.usercards = res;
         }
         else{
         this.errorMessage = "No matching slots found";
         }
      });
}

}
