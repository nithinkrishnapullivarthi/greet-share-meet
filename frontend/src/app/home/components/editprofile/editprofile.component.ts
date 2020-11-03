import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HomeService } from '../../services/home.service';


@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.scss']
})
export class EditprofileComponent implements OnInit {

  public editprofileForm: FormGroup;
  loaded = false;

  constructor(private fb: FormBuilder,
    private homeService: HomeService,
    private router: Router) { }

  ngOnInit(): void {
    this.homeService.getUserInfo().subscribe(res => {
      this.editprofileForm = this.fb.group({
        name: [res.name, [Validators.required, Validators.minLength(3)]],
        email: [res.email, [Validators.required, Validators.email]],
        department: [res.department, Validators.required],
        contact: [res.contact, [Validators.required, Validators.pattern("[0-9]{10}"), Validators.maxLength(10)]],
        username: new FormControl({ value: res.name, disabled: true }, [Validators.required, Validators.minLength(6)]),
        password: ['XXXXXXXXX', [Validators.required, Validators.minLength(8)]]
      });
      this.loaded = true;
    });

  }


  onUpdate() {

  }
}



