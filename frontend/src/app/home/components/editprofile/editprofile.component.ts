import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HomeService } from '../../services/home.service';

import { UpdateProfile } from '../../models/updateprofile.model';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.scss']
})
export class EditprofileComponent implements OnInit {

  public editprofileForm: FormGroup;
  loaded = false;
  updateuser: UpdateProfile;
  errorMessage =null;

  constructor(private fb: FormBuilder,
    private homeService: HomeService,
    private router: Router,private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.homeService.getUserProfile().subscribe(res => {
      this.editprofileForm = this.fb.group({
        name: [res.name, [Validators.required, Validators.minLength(3)]],
        email: [res.email, [Validators.required, Validators.email]],
        department: [res.department, Validators.required],
        contact: [res.contact, [Validators.required, Validators.pattern("[0-9]{10}"), Validators.maxLength(10)]],
      });
      this.updateuser=res;
      this.loaded = true;
    });

  }
  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 2000,
    });
  }

  onUpdate() {
   
    let updateduser = this.updateuser;
    updateduser.email=this.editprofileForm.controls.email.value;
    updateduser.name=this.editprofileForm.controls.name.value;
    updateduser.department=this.editprofileForm.controls.department.value;
    updateduser.contact=this.editprofileForm.controls.contact.value;
    console.log(updateduser);
    this.homeService.updateUserProfile(updateduser).subscribe(res => {
      if(!res){
        this.errorMessage = "Some thing bad happened. Please try again later";
      }
      else{
        this.openSnackBar('Profile updated Successfully!', 'x')
        this.router.navigate(['homepage']);
      }
    })
  }
}



