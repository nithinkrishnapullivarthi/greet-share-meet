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
  errorMessage = null;
  constructor
    (private fb: FormBuilder,
      private router: Router,
      private loginservice: AuthenticationService) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(6)]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }

  onSubmit() {
    let loginrequest = new LoginRequest();
    loginrequest = this.loginForm.value;
    this.loginservice.loginAuthentication(loginrequest).subscribe(res => {
      if ((!res.hasOwnProperty('message'))) {
        this.router.navigate(['homepage']);
      } else {
          if(res.message=="USER_NOT_FOUND")
            console.log(res.message)
            this.errorMessage = "Account not found. Please register";
          if(res.message=="INVALID_CREDENTIALS")
            this.errorMessage = "Incorrect Username or Password";
      }
    });
  }

}
