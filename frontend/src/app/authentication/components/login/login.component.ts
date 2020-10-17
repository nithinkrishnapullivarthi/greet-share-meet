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
  public loginForm: FormGroup;
  invalidLogin = {
    isError: false,
    message: ''
  };
  constructor
    (private fb: FormBuilder,
      private router: Router,
      private loginservice: AuthenticationService) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(6)]],
      password: ['', [Validators.required,Validators.minLength(6)]],
    });
  }

  onSubmit() {
    let loginrequest = new LoginRequest();
    loginrequest = this.loginForm.value;
    
    this.loginservice.loginAuthentication(loginrequest).subscribe(res => {
      if (!(res.isError) && res.data) {
        this.router.navigate(['home']);
      }
      else {
        this.invalidLogin = { isError: res.isError, message: res.message }
      }
      console.log(res);
    });


  }

}
