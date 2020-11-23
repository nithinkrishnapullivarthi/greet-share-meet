import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatRadioChange } from '@angular/material/radio'
import { HomeService } from '../../services/home.service';
import { RegisterRequest } from '../../../authentication/models';
import { UpdateInterest } from '../../models/updateinterest.model'
import { UpdateInterestsRequest } from '../../models/updateInterestsRequest.model';
import { Interest } from '../../models/interest.model';
import {MatSnackBar} from '@angular/material/snack-bar';
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
  selected_volunteer_interests: string[] = [];
  selsports: string[] = [];
  selacad: string[] = [];
  selacti: string[] = [];
  selmus: string[] = [];
  showvolunteer: boolean = false;
  volunteerInterestsSet= new Set<string>();
  isVolunteer: string;
  loaded = false;
  $event = MatRadioChange;
  updateInterestRequest = new UpdateInterestsRequest();
  updateuserinterest: UpdateInterest;
  pre_volunteer_interests= new Set<string>();
  constructor(private fb: FormBuilder,
    private homeService: HomeService,
    private router: Router,private _snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.homeService.getUserInterests().subscribe(res => {
      console.log(res);
      console.log(res.volunteer_interests)
      this.isVolunteer = res.is_volunteer.toString();
      if (res.is_volunteer) {
        for (let i = 0; i < res.volunteer_interests.length; i++) {
          let volint = res.volunteer_interests[i];
          this.pre_volunteer_interests.add(volint["interest"]);
        }
        this.selected_volunteer_interests = Array.from(this.pre_volunteer_interests);
      }
      for (let i = 0; i < res.interests.length; i++) {
        let rows = res.interests[i];
        if(rows["category"]=="Sports")
          this.selsports.push(rows["interest"]);
        if(rows["category"]=="Musical Instruments")
          this.selmus.push(rows["interest"]);
        if(rows["category"]=="Other Activities")
          this.selacti.push(rows["interest"]);
        if(rows["category"]=="Academics")
          this.selacad.push(rows["interest"]);
      }
      this.addeditinterestsForm = this.fb.group({

        is_volunteer: [Validators.required],
        selected_volunteer_interests: [Array.from(this.pre_volunteer_interests),Validators.required],
        sports: [this.selsports],
        academics: [this.selacad],
        activities: [this.selacti],
        musicalInstruments: [this.selmus]

      });
      
      this.loaded = true;
      console.log(res);
      this.updateuserinterest = res;
      this.onFormChanges();
      if (res.is_volunteer==true) {
        this.addeditinterestsForm.get('selected_volunteer_interests').enable();
      }
      else {
        this.addeditinterestsForm.get('selected_volunteer_interests').disable();
      }
    });

  }

  public onFormChanges() {

    this.addeditinterestsForm.valueChanges.subscribe(res => {

      this.updateRequestObject(res);
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
      this.pre_volunteer_interests = new Set<string>();
      this.selsports.forEach(item => this.pre_volunteer_interests.add(item));
      this.selacad.forEach(item => this.pre_volunteer_interests.add(item));
      this.selacti.forEach(item => this.pre_volunteer_interests.add(item));
      this.selmus.forEach(item => this.pre_volunteer_interests.add(item));
      this.volunteer_interests = Array.from(this.pre_volunteer_interests);
      for (let i = 0; i < this.selected_volunteer_interests.length; i++) {
        let selected_volunteer_interest = this.selected_volunteer_interests[i];
        if(res.sports.indexOf(selected_volunteer_interest) == -1 && res.academics.indexOf(selected_volunteer_interest)== -1 && res.activities.indexOf(selected_volunteer_interest) == -1 && res.musicalInstruments.indexOf(selected_volunteer_interest) == -1) {
            this.selected_volunteer_interests.splice(i,1);
        }
      }
     


    });
  }

  updateRequestObject(res : any){
    let interests = new Array<Interest>();
    let volunteer_interests = new Array<Interest>();
    for (let i = 0; i < res.sports.length; i++) {
      let inter = new Interest;
      inter.category = "Sports";
      inter.interest = res.sports[i];
      interests.push(inter);
    }
    for (let i = 0; i < res.musicalInstruments.length; i++) {
      let inter = new Interest;
      inter.category = "Musical Instruments";
      inter.interest = res.musicalInstruments[i];
      interests.push(inter);
    }
    for (let i = 0; i < res.activities.length; i++) {
      let inter = new Interest;
      inter.category = "Other Activities";
      inter.interest = res.activities[i];
      interests.push(inter);
    }
    for (let i = 0; i < res.academics.length; i++) {
      let inter = new Interest;
      inter.category = "Academics";
      inter.interest = res.academics[i];
      interests.push(inter);
    }
    if(res.selected_volunteer_interests!=undefined){
      for (let i = 0; i < res.selected_volunteer_interests.length; i++) {
        if(res.academics.indexOf(res.selected_volunteer_interests[i]) > -1){
          let inter = new Interest;
          inter.category = "Academics";
          inter.interest = res.selected_volunteer_interests[i];
          volunteer_interests.push(inter);
        }
        if(res.activities.indexOf(res.selected_volunteer_interests[i]) > -1){
          let inter = new Interest;
          inter.category = "Other Activities";
          inter.interest = res.selected_volunteer_interests[i];
          volunteer_interests.push(inter);
        }
        if(res.musicalInstruments.indexOf(res.selected_volunteer_interests[i]) > -1){
          let inter = new Interest;
          inter.category = "Musical Instruments";
          inter.interest = res.selected_volunteer_interests[i];
          volunteer_interests.push(inter);
        }
        if(res.sports.indexOf(res.selected_volunteer_interests[i]) > -1){
          let inter = new Interest;
          inter.category = "Sports";
          inter.interest = res.selected_volunteer_interests[i];
          volunteer_interests.push(inter);
        }
      }
    }
      this.updateInterestRequest.is_volunteer = res.is_volunteer;
      this.updateInterestRequest.interests = interests;
      this.updateInterestRequest.volunteer_interests = volunteer_interests;
    }
    

  onRadioChange($event: MatRadioChange, controlName: string | null) {
    if (controlName == 'is_volunteer') {
      if ($event.value == 'true') {
        this.showvolunteer = true;
        this.addeditinterestsForm.get('selected_volunteer_interests').enable();
      }
      else {
        this.showvolunteer = false;
        this.addeditinterestsForm.get('selected_volunteer_interests').disable();
      }
    }
  }
  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 2000,
    });
  }
  onUpdate() {
    this.homeService.updateUserInerests(this.updateInterestRequest).subscribe(res => {
      if (!res) {
        this.errorMessage = "Some thing bad happened. Please try again later";
      }
      else {
        this.openSnackBar('Interests updated Successfully!', 'x')
        this.router.navigate(['homepage']);
      }
    })
  }

}
