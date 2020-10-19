import { Injectable } from '@angular/core';
import { HttpService } from 'src/app/shared/services/http.service';
import { LoginRequest } from '../models';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse } from '@angular/common/http'
import { environment } from 'src/environments/environment';
import { catchError, map, tap } from 'rxjs/operators'
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  data: any;

  constructor(private http: HttpService, private _http: HttpClient) {

  }

  public loginAuthentication(request: LoginRequest): Observable<any> {
    return this._http.post<any>(environment.baseUrl + "/v1/meet-greet/students/login", request).pipe(
      tap(response => {
        if (!(response.message)) {
          sessionStorage.setItem('user', JSON.stringify(response));
        }
      }),
      catchError(error => this.handleError(error))
    );

  }
  private handleError(error: HttpErrorResponse) {
    return throwError(
      'Something bad happened; please try again later.');
  }
  isUserLoggedIn() {
    let user = sessionStorage.getItem('user');
    console.log(!(user === null))
    return (user === null)
  }

  logOut() {
    sessionStorage.removeItem('user');
  }
}
