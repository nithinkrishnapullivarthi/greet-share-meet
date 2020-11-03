import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {MatRadioChange} from '@angular/material/radio'
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

  volunteer_interests: string[] = [];
  selsports:string[]=[];
  selacad:string[]=[];
  selacti:string[]=[];
  selmus:string[]=[];
  showvolunteer: boolean = false;

  constructor(private fb: FormBuilder,
    private router: Router, 
  ) { }

  ngOnInit(): void {

    this.addeditinterestsForm = this.fb.group({
      is_volunteer: ['', Validators.required],
      volunteer_interests:[{value: '', disabled:true},Validators.required],
      sports: [],
      academics:[],
      activities:[],
      musicalInstruments:[]
    });

    this.onFormChanges();
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
