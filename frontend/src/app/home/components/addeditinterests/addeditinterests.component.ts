import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatRadioChange } from '@angular/material/radio'
import { HomeService } from '../../services/home.service';
import { RegisterRequest } from '../../../authentication/models';
import { UpdateInterest } from '../../models/updateinterest.model'
@Component({
  selector: 'app-addeditinterests',
  templateUrl: './addeditinterests.component.html',
  styleUrls: ['./addeditinterests.component.scss']
})
export class AddeditinterestsComponent implements OnInit {

  sportsList: string[] = ['Tennis', 'Football', 'Soccer', 'Badminton', 'Basketball'];
  academicsList: string[] = ['Physics', 'Mathematics', 'Chemistry', 'Big Data', 'Machine learning', 'Artificial Intelligence', 'Analytics'];
  activitiesList: string[] = ['Running', 'Traveling', 'Homework', 'Rock Climbing', 'Public Speaking'];
  musicalInstrumentsList: string[] = ['Guitar', 'Piano', 'Drums', 'Flute', 'Cello'];


  public addeditinterestsForm: FormGroup;
  errorMessage = null;
  volunteer_interests: string[] = [];
  selsports: string[] = [];
  selacad: string[] = [];
  selacti: string[] = [];
  selmus: string[] = [];
  showvolunteer: boolean = false;
  loaded = false;
  $event = MatRadioChange;
  updateuserinterest: UpdateInterest;
  pre_volunteer_interests: string[]=[];
  constructor(private fb: FormBuilder,
    private homeService: HomeService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.homeService.getUserInterests().subscribe(res => {
      console.log(res);
      console.log(res.volunteer_interests)
      if (res.is_volunteer) {
        for (let i = 0; i < res.interests.length; i++) {
          let rows = res.interests[i];
          if(rows["category"]=="Sports")
            this.selsports.push(rows["interest"]);
        }
        for (let i = 0; i < res.volunteer_interests.length; i++) {
          let volint = res.volunteer_interests[i];
          this.pre_volunteer_interests.push(volint["interest"]);
        }
      }
      this.addeditinterestsForm = this.fb.group({

        is_volunteer: [{ value: res.is_volunteer, }, Validators.required],
        volunteer_interests: [this.pre_volunteer_interests, Validators.required],
        sports: [this.selsports],
        academics: [],
        activities: [],
        musicalInstruments: []

      });
      this.loaded = true;
      console.log(res);
      this.updateuserinterest = res;
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
      this.volunteer_interests = [...this.selsports, ...this.selacad, ...this.selacti, ...this.selmus,...this.pre_volunteer_interests]
    });
  }

  onRadioChange($event: MatRadioChange, controlName: string | null) {
    if (controlName == 'is_volunteer') {
      if ($event.value == 'true') {
        this.showvolunteer = true;
        this.addeditinterestsForm.get('volunteer_interests').enable();
      }
      else {
        this.showvolunteer = false;
        this.addeditinterestsForm.get('volunteer_interests').disable();
      }
    }
  }

  onUpdate() {
    let updateduserinterest = this.updateuserinterest;
    updateduserinterest.interests = this.volunteer_interests;
    this.homeService.updateUserInerests(updateduserinterest).subscribe(res => {
      if (!res) {
        this.errorMessage = "Some thing bad happened. Please try again later";
      }
      else {
        this.router.navigate(['home']);
      }
    })
  }

}
