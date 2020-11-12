import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: './register-time-slots.component.html',
  styleUrls: ['./register-time-slots.component.scss']
})
 
export class RegisterTimeSlotsComponent implements OnInit {
  
  minDate = new Date();
  maxDate = new Date(2021, 0, 1);
  
  selectedValue: string;
  public registerTimeSlotsForm : FormGroup;

  interests = [
    {value: 'Sports', viewValue: 'BasketBall'},
    {value: 'Academics', viewValue: 'Physics'},
    {value: 'PublicActivities', viewValue: 'Running'},
    {value: 'MusicalInstruments', viewValue: 'Guitar'},
  ];;
  constructor(private fb: FormBuilder,private router: Router){

  }

  ngOnInit(): void {
    this.registerTimeSlotsForm=this.fb.group({
      interest:['',Validators.required],
      startDate:['',Validators.required],
      endDate:['',Validators.required],
      startTime:['',Validators.required],
      endTime:['',Validators.required]

    });

  }
  onRegisterTimeSlot(){
    

  }
  }
