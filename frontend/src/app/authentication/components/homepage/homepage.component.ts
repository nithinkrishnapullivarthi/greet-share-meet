import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthenticationService } from '../../services/authentication.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {

  constructor(private homeservice:AuthenticationService,
              private fb: FormBuilder,
              private router: Router, ) {

   }
   public searchForm: FormGroup;
   
   
   searchParam:string = "";
   public cards: any;
   public cardsDummy: any;
   public userJson: any =[];
  ngOnInit(): void {
             this.searchForm = this.fb.group({
               searchParam:['']
             });
         let user = sessionStorage.getItem('user');
         this.userJson = JSON.parse(user);
         console.log('this is userjson',this.userJson.id);
             this.homeservice.getStudents(this.userJson.id).subscribe(res => {
                if(res){
                this.cardsDummy = res;
                this.cards = this.cardsDummy
                }
             });
  }
  onSearch(){
    let searchResults: Object[] = [];

  //alert('onSearch');
    let searchVal = this.searchForm.value.searchParam;
    let varval:any;
    if(searchVal == ""){
      this.cards = this.cardsDummy;
    }
    else{
      this.cards = this.cardsDummy;
      for(let i of this.cards){
        for(let j of i.interests)
        {
          console.log(j.toLowerCase());
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
        console.log('value of I =', i);
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
        console.log(varval);
        searchResults:searchResults.push(varval);
        console.log('values of i: ',typeof(i));
        }
      }
      if(searchResults.length!=0)
      {
        this.cards=searchResults;
      }
      else{
        alert('No such users found')
      }
    }
  }
}
