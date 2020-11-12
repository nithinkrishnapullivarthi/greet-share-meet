import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router';
import { HomeService } from '../../../home/services/home.service';
@Component({
  selector: 'app-register',
  templateUrl: './register-time-slots.component.html',
  styleUrls: ['./register-time-slots.component.scss']
})
 
export class RegisterTimeSlotsComponent implements OnInit {
  
  minDate = new Date();
  maxDate = new Date(2022, 0, 1);
  
  miDate = new Date();
  maDate = new Date(2022, 0, 1);

  selectedValue: string;
  public registerTimeSlotsForm : FormGroup;

  interests = [
    {value: 'Sports', viewValue: 'BasketBall'},
    {value: 'Academics', viewValue: 'Physics'},
    {value: 'PublicActivities', viewValue: 'Running'},
    {value: 'MusicalInstruments', viewValue: 'Guitar'},
  ];;
  constructor(private fb: FormBuilder,private router: Router,private homeService: HomeService,){

  }

  ngOnInit(): void {
    this.homeService.getUserInfo().subscribe(res => {
      console.log(res.interests);
    this.registerTimeSlotsForm=this.fb.group({
      interest:['',Validators.required],
      startDate:['',Validators.required],
      endDate:['',Validators.required],
      startTime:['',Validators.required],
      endTime:['',Validators.required]

    });
  });
  }
  onRegisterTimeSlot(){
    

  }
  }
