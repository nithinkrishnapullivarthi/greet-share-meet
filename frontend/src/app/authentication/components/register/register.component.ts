import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import {MatRadioChange} from '@angular/material/radio'
import {RegisterRequest} from '../../models/register.model'
import { AuthenticationService } from '../../services/authentication.service';
import {MatSnackBar} from '@angular/material/snack-bar';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})

export class RegisterComponent implements OnInit {

  sportsList: string[] = ['Tennis', 'Football', 'Soccer', 'Badminton', 'Basketball'];
  academicsList: string[]=['Physics', 'Mathematics' ,'Chemistry','Big Data', 'Machine learning', 'Artificial Intelligence' ,'Analytics'];
  activitiesList: string[]=['Running','Traveling','Homework','Rock Climbing','Public Speaking'];
  musicalInstrumentsList: string[]=['Guitar','Piano','Drums','Flute','Cello'];
  
  public registerForm: FormGroup;
  errorMessage = null;
  volunteer_interests: string[] = [];
  selected_volunteer_interests: string[] = [];
  selsports:string[]=[];
  selacad:string[]=[];
  selacti:string[]=[];
  selmus:string[]=[];
  showvolunteer: boolean = false;
  department = new FormControl('',[Validators.required]);
  constructor(private fb: FormBuilder,
    private router: Router, 
    private registerservice: AuthenticationService,private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      name: ['', [Validators.required,Validators.minLength(3)]],
      email: ['', [Validators.required,Validators.email]],
      department: ['', Validators.required],
      contact: ['', [Validators.required,Validators.pattern("[0-9]{10}"),Validators.maxLength(10)]],
      username: ['', [Validators.required, Validators.minLength(6)]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      is_volunteer: ['', Validators.required],
      selected_volunteer_interests:[{value: '', disabled:true},Validators.required],
      sports: [],
      academics:[],
      activities:[],
      musicalInstruments:[]
  
    });

    this.onFormChanges();
  }
  
  public onFormChanges() {
    
    this.registerForm.valueChanges.subscribe(res => {
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
      this.volunteer_interests=[...this.selsports,...this.selacad,...this.selacti,...this.selmus  ];
      if(this.selected_volunteer_interests.length > 0){
        for (let i = 0; i < this.selected_volunteer_interests.length; i++) {
          let selected_volunteer_interest = this.selected_volunteer_interests[i];
          if(this.selsports.indexOf(selected_volunteer_interest) == -1 && this.selacad.indexOf(selected_volunteer_interest)== -1 && this.selacti.indexOf(selected_volunteer_interest) == -1 && this.selmus.indexOf(selected_volunteer_interest) == -1) {
              this.selected_volunteer_interests.splice(i,1);
          }
        }
      } 
    });
  }
  onRadioChange($event: MatRadioChange, controlName:string | null) {
    if (controlName == 'is_volunteer') {
      if ($event.value == 'true') {
        this.showvolunteer = true;
        this.registerForm.get('selected_volunteer_interests').enable();
      }
      else{
        this.showvolunteer = false;
        this.registerForm.get('selected_volunteer_interests').disable();
      }
    }
  }
  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 2000,
    });
  }
  onRegister() {
    let regRequest = new RegisterRequest();
    regRequest= this.registerForm.value;
    regRequest.interests=this.volunteer_interests;
    regRequest.volunteer_interests=this.selected_volunteer_interests;
    this.registerservice.registerUser(regRequest).subscribe(res=>{
      if ((!res.hasOwnProperty('message'))) {
        this.openSnackBar('Registered Successfully!', 'x')
        this.router.navigate(['authentication/login']);
      } else {
          if(res.message=="USERNAME_EXISTS")
            this.errorMessage = "Username already exists.";
      }
    });
  }
  private validateusername(){

  }
  
}
