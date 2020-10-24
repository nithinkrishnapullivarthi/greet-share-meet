import { Injectable } from '@angular/core';
import { HttpService } from 'src/app/shared/services/http.service';
import { LoginRequest } from '../models';
import { RegisterRequest } from '../models';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse } from '@angular/common/http'
import { environment } from 'src/environments/environment';
import { catchError, map, tap } from 'rxjs/operators'
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  constructor(private http: HttpClient) {

  }

  public loginAuthentication(request: LoginRequest): Observable<any> {
    return this.http.post<any>(environment.baseUrl + "/v1/meet-greet/students/login", request).pipe(
      tap(response => {
        if (!(response.message)) {
          sessionStorage.setItem('user', JSON.stringify(response));
        }
      }),
      catchError(error => this.handleError(error))
    );

  }
  isUserLoggedIn() {
    let user = sessionStorage.getItem('user');
    console.log(!(user === null))
    return (user === null)
  }
  public registerUser(register :RegisterRequest):Observable<any>{
    return this.http.post<any>(environment.baseUrl+"/v1/meet-greet/students/registration",register).pipe(
      tap(response =>{
      }),
      catchError(error => this.handleError(error))
    )
  }
  private handleError(error: HttpErrorResponse) {
    return throwError(
      'Something bad happened; please try again later.');
  }
  logOut() {
    sessionStorage.removeItem('user');
  }
  
}
