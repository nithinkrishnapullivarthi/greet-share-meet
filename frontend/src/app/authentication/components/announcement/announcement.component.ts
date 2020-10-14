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


  
  ngOnInit(): void {
    this.announcementForm = this.form.group({
      announcement: ['', [Validators.required,Validators.minLength(5)]],
      tags:[[],[Validators.required]]
    });
  }
  onAnnounce() {
    let announcementRequest = new AnnouncementRequest();
    announcementRequest= this.announcementForm.value;
  }
}