import { Injectable } from '@angular/core';
import { HttpService } from 'src/app/shared/services/http.service';
import { LoginRequest } from '../models';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  data: any;

  constructor(private http: HttpService) {
    this.http.getConfig('assets/mock/data.json').subscribe(resp => {
      this.data = resp;
    });
  }

  authenticate(request: LoginRequest) {
    if (!this.data.hasOwnProperty(request.userName)) {
      return {
        status: false,
        description: 'User not found'
      }
    } else {
      const user = this.data[request.userName];
      const status = (user.isActive) && (user.userName === request.userName) && (user.password === request.password);
      status && sessionStorage.setItem('uaser', JSON.stringify(user));

      return {
        status,
        description: status ? 'Authentication successuful!' : (user.isActive ? 'Incorrect password!' : 'User access hasbeen restricted')
      }
    }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('uaser');
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('uaser');
  }
}
