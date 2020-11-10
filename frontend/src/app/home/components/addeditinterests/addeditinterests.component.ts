import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {MatRadioChange} from '@angular/material/radio'
import { HomeService } from '../../services/home.service';
@Component({
  selector: 'app-addeditinterests',
  templateUrl: './addeditinterests.component.html',
  styleUrls: ['./addeditinterests.component.scss']
})
export class AddeditinterestsComponent implements OnInit {

  sportsList: string[] = ['Tennis', 'Football', 'Soccer', 'Badminton', 'Basketball'];
  academicsList: string[]=['Physics', 'Mathematics' ,'Chemistry','Big Data', 'Machine learning', 'Artificial Intelligence' ,'Analytics'];
  activitiesList: string[]=['Running','Traveling','Homework','Rock Climbing','Public Speaking'];
  musicalInstrumentsList: string[]=['Guitar','Piano','Drums','Flute','Cello'];

   
  public addeditinterestsForm: FormGroup;
  errorMessage = null;
  volunteer_interests: string[] = [];
  selsports:string[]=[];
  selacad:string[]=[];
  selacti:string[]=[];
  selmus:string[]=[];
  showvolunteer: boolean = false;
  loaded = false;
  constructor(private fb: FormBuilder,
     private homeService: HomeService,
    private router: Router, 
  ) { }

  ngOnInit(): void {
    this.homeService.getUserInfo().subscribe(res => {
      console.log(res);
      console.log(res.volunteer_interests)
      this.addeditinterestsForm = this.fb.group({
        is_volunteer: ['' , Validators.required],
        volunteer_interests:[[res.volunteer_interests],Validators.required],
        sports: [[res.volunteer_interests]],
        academics:[[res.volunteer_interests]],
        activities:[[res.volunteer_interests]],
        musicalInstruments:[[res.volunteer_interests]]
        
      });
      this.loaded=true;
      this.onFormChanges();
    });
      
  }

  public onFormChanges() {
    
    this.addeditinterestsForm.valueChanges.subscribe(res => {
      if (res.sports) {
        this.selsports = [...res.sports];
      }
      if (res.academics) {
        this.selacad = [...res.academics];
      }
      if (res.activities) {
        this.selacti = [...res.activities];
      }
      if (res.musicalInstruments) {
        this.selmus = [...res.musicalInstruments];
      }
      this.volunteer_interests=[...this.selsports,...this.selacad,...this.selacti,...this.selmus  ]
    });
  }

  onRadioChange($event: MatRadioChange, controlName:string | null) {
    if (controlName == 'is_volunteer') {
      if ($event.value == 'true') {
        this.showvolunteer = true;
        this.addeditinterestsForm.get('volunteer_interests').enable();
      }
      else{
        this.showvolunteer = false;
        this.addeditinterestsForm.get('volunteer_interests').disable();
      }
    }
  }

  onUpdate()
  {
    
  }

}
