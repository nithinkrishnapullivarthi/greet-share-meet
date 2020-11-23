import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router';
import {RegisterTimeSlots} from '../../models/registertimeslots.model';
import { HomeService } from '../../../home/services/home.service';
import {MatSnackBar} from '@angular/material/snack-bar';
@Component({
  selector: 'app-register',
  templateUrl: './register-time-slots.component.html',
  styleUrls: ['./register-time-slots.component.scss']
})
 
export class RegisterTimeSlotsComponent implements OnInit {
  
  minDate = new Date();
  maxDate = new Date(2022, 0, 1);
  
  miDate = new Date(this.minDate);
  maDate = new Date(2022, 0, 1);
  
  
  timeslot : RegisterTimeSlots;
  selectedValue: string;
  errorMessage =null;
  

  public registerTimeSlotsForm : FormGroup;
  loaded = false;
  userInterests:string[]=[];
  interests:string[]= [];
  constructor(private fb: FormBuilder,private router: Router,private homeService: HomeService,private _snackBar: MatSnackBar ){

  }

  ngOnInit(): void {
    this.homeService.getUserInfo().subscribe(res => {
      for(let i=0;i<res.interests.length;i++){
        let obj = res.interests[i];
        this.userInterests.push(obj["interest"]);

    }
    this.interests=this.userInterests;  
    this.registerTimeSlotsForm=this.fb.group({
      interests:[this.interests,Validators.required],
      startDate:['',Validators.required],
      endDate:['',Validators.required],
      startTime:['',Validators.required],
      endTime:['',Validators.required]

    });
    this.timeslot = new RegisterTimeSlots();
    this.timeslot.studentId=res.id;
    this.loaded=true;
    console.log(this.timeslot);
    this.onFormChnages();
  });
  }
  onFormChnages(){
    this.registerTimeSlotsForm.valueChanges.subscribe(res => {
      let sDate = (JSON.stringify(res.startDate)).substring(1,11);
      let eDate = (JSON.stringify(res.endDate)).substring(1,11);
      let sTime = (res.startTime);
      let eTime = (res.endTime);
      this.timeslot.interest=this.registerTimeSlotsForm.controls.interests.value;
      console.log(this.timeslot.interest);
      if(sDate!=null && sDate!=undefined)
      {
        this.miDate=res.startDate;
      }
      this.timeslot.startDateTime=sDate+" "+sTime;
      console.log(this.timeslot.startDateTime);
      this.timeslot.endDateTime=eDate+" "+eTime;
      console.log(this.timeslot.endDateTime);
      
     
    });
  }
  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 5000,
    });
  }
  
  onRegisterTimeSlot(){
    console.log(this.timeslot);
    this.homeService.registerUserTimeSlot(this.timeslot).subscribe(res => {
      if(!res){
        this.errorMessage = "Some thing bad happened. Please try again later";
      }
      else{
        this.router.navigate(['matchmaking/viewtimeslots' ]);
      }
    })
   

  


  }
  }
