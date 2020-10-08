import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../services/authentication.service';
import { FormControl, FormGroup, FormBuilder, Validator, ReactiveFormsModule, Validators } from "@angular/forms"
import { Router } from '@angular/router';
import { LoginRequest } from '../../models';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  private loginComponent: LoginComponent;
  public loginForm: FormGroup;
  invalidLogin = {
    status: false,
    description: ''
  };
  constructor
    (private fb: FormBuilder,
      private router: Router,
      private loginservice: AuthenticationService) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      userName: ['', [Validators.required, Validators.minLength(5)]],
      password: ['', Validators.required],
    });
  }

  onSubmit() {
    let loginRequest = new LoginRequest();
    loginRequest = this.loginForm.value;
  const res=this.loginservice.authenticate(loginRequest);
    if(res.status ) {
      this.router.navigate(['home/home']);
    }
    else {
      this.invalidLogin = res;
    }
  }

}
