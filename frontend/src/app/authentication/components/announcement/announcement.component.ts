import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {AnnouncementRequest} from '../../models/announce.model'
import { AuthenticationService } from '../../services/authentication.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-announcement',
  templateUrl: './announcement.component.html',
  styleUrls: ['./announcement.component.scss']
})
export class AnnouncementComponent implements OnInit {
  public announcementForm: FormGroup;
  public navigationForm: FormGroup;
  constructor(private form: FormBuilder,
    private router: Router,
    private announcementservice: AuthenticationService
  ) { }
public interests : [];
 public id:number;
 public userJson: any;


  ngOnInit(): void {
     let user = sessionStorage.getItem('user');
     this.userJson = JSON.parse(user);
     console.log(this.userJson);
     //this.interests = this.userJson.interest;
     //this.announcementservice.getLoggedUserDetails(this.userJson.id).subscribe
     //

         this.announcementservice.getLoggedUserDetails(this.userJson.id).subscribe(res => {
            console.log('tried reaching here');
            if(res){
            this.interests = res.interests;
            console.log('user interests', this.interests);
            }
         });

     //
    this.announcementForm = this.form.group({
      announcement: ['', [Validators.required,Validators.minLength(5)]],
      interest:[[],[Validators.required]]
    });
  }
  onAnnounce() {
  alert('hello');
    console.log(Router.name);
    console.log(this.announcementForm);
    let announcementRequest = new AnnouncementRequest();
    announcementRequest.studentId = this.userJson.id;
    announcementRequest.announcement = this.announcementForm.value.announcement;
    announcementRequest.interest = this.announcementForm.value.interest[0];
    this.announcementservice.makeAnnouncement(announcementRequest).subscribe(res => {
            console.log(res);
           if(res){
           console.log('id=',res);
           }

       });
  }

}
