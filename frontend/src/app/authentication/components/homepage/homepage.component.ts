import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthenticationService } from '../../services/authentication.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {

  constructor(private homeservice:AuthenticationService,
              private fb: FormBuilder,
              private router: Router,
              private _snackBar: MatSnackBar ) {

   }
   public searchForm: FormGroup;
   
   searchParam:string = "";
   public cards: any;
   public cardsDummy: any;
   public userJson: any =[];
  ngOnInit(): void {
             this.cards=[]; 
             this.searchForm = this.fb.group({
               searchParam:['']
             });
         let user = sessionStorage.getItem('user');
         this.userJson = JSON.parse(user);
             this.homeservice.getStudents(this.userJson.id).subscribe(res => {
                if(res){
                this.cardsDummy = res;
                this.cards = this.cardsDummy
                }
             });
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 2000,
    });
  }

  onSearch(){
    let searchResults: Object[] = [];

  //alert('onSearch');
    let searchVal = this.searchForm.value.searchParam;
    let varval:any;
    let searchlen:number  = searchVal.length;
    if(searchVal == ""){
      this.cards = this.cardsDummy;
    }
    else{
      this.cards = this.cardsDummy;
      for(let i of this.cards){

        for(let j of i.interests)
        {
          if(j.substring(0,searchlen).toLowerCase() == searchVal.substring(0,searchlen).toLowerCase() && j.toLowerCase()!=searchVal.toLowerCase())
          {
            varval = {
              id: i.id,
              name: i.name,
              department: i.department,
              email:i.email,
              is_volunteer:i.is_volunteer,
              contact:i.contact,
              interests:i.interests,
              volunteer_interests:i.volunteer_interests
            };
            searchResults:searchResults.push(varval);
            continue;
          }
        }
        for(let j of i.interests)
        {
          if(j.toLowerCase() == searchVal.toLowerCase())
          {
            varval = {
              id: i.id,
              name: i.name,
              department: i.department,
              email:i.email,
              is_volunteer:i.is_volunteer,
              contact:i.contact,
              interests:i.interests,
              volunteer_interests:i.volunteer_interests
            };
            searchResults:searchResults.push(varval);
            continue;
          }
        }


        if(i.name.substring(0,searchlen).toLowerCase() == searchVal.substring(0,searchlen).toLowerCase() && i.name.toLowerCase()!= searchVal.toLowerCase()){
          //this.searchResults.push(i);
           varval = {
            id: i.id,
            name: i.name,
            department: i.department,
            email:i.email,
            is_volunteer:i.is_volunteer,
            contact:i.contact,
            interests:i.interests,
            volunteer_interests:i.volunteer_interests
          };
          searchResults:searchResults.push(varval);
          
          }

          if(i.name.toLowerCase() == searchVal.toLowerCase()){
          //this.searchResults.push(i);
           varval = {
            id: i.id,
            name: i.name,
            department: i.department,
            email:i.email,
            is_volunteer:i.is_volunteer,
            contact:i.contact,
            interests:i.interests,
            volunteer_interests:i.volunteer_interests
          };
          searchResults:searchResults.push(varval);
          console.log(typeof(searchResults));

          }


      }

      if(searchResults.length!=0)
      {
        this.cards=searchResults;
      }
      else{
        this.cards =[];
      }
    }
  }
}
