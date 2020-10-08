import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import {MatRadioChange} from '@angular/material/radio'
import {RegisterRequest} from '../../models/register.model'


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})

export class RegisterComponent implements OnInit {

  sportsList: string[] = ['tennis', 'football', 'soccer', 'badminton', 'basketball'];
  academicsList: string[]=['physics', 'mathematics' ,'chemistry','bigdata', 'machinelearning', 'artificialintelligence' ,'analytics'];
  activitiesList: string[]=['running','travelling','homework','rockclimbing','speaking'];
  musicalInstrumentsList: string[]=['guitar','piano','drums','flute'];
  public registerForm: FormGroup;
  invalidLogin = {
    status: false,
    description: ''
  };
  volunteerTo: string[] = [];
  selsports:string[]=[];
  selacad:string[]=[];
  selacti:string[]=[];
  selmus:string[]=[];
  showvolunteer: boolean = false;
  department = new FormControl('',[Validators.required]);
  constructor(private fb: FormBuilder,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      name: ['', [Validators.required,Validators.minLength(3)]],
      email: ['', [Validators.required,Validators.email]],
      department: ['', Validators.required],
      contactNumber: ['', [Validators.required,Validators.pattern("[0-9]{10}")]],
      userName: ['', [Validators.required, Validators.minLength(6)]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      volunteerradio: ['', Validators.required],
      volunteer:[{value: '', disabled:true},Validators.required],
      sports: [],
      academics:[],
      activities:[],
      musicalInstruments:[]
  
    });

    this.onFormChanges();
  }
  
  public onFormChanges() {
    
    this.registerForm.valueChanges.subscribe(res => {
      console.log(res);
      
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
      this.volunteerTo=[...this.selsports,...this.selacad,...this.selacti,...this.selmus  ]
    });
  }

  onRadioChange($event: MatRadioChange, controlName:string | null) {
    if (controlName == 'volunteerradio') {
      if ($event.value == 'yes') {
        this.showvolunteer = true;
        this.registerForm.get('volunteer').enable();
      }
      else{
        this.showvolunteer = false;
        this.registerForm.get('volunteer').disable();
      }
    }
  }
  onRegister() {
    let regRequest = new RegisterRequest();
    regRequest= this.registerForm.value;
    

  }
  private validateusername(){

  }
  
}
