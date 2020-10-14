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
    this.http.getConfig('assets/mock/data.json').subscribe(resp => {
      this.data = resp;
    });
  }

  authenticate1(request: LoginRequest) {
    if (!this.data.hasOwnProperty(request.username)) {
      return {
        status: false,
        description: 'User not found'
      }
    } else {
      const user = this.data[request.username];
      const status = (user.isActive) && (user.userame === request.username) && (user.password === request.password);
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

  public loginAuthentication(request: LoginRequest): Observable<any> {
    return this._http.post<any>(environment.baseUrl + "/v1/meet-greet/students/login", request).pipe(
      tap(response => {
        if (!(response.isError) && response.data) {
          sessionStorage.setItem('uaser', JSON.stringify(response.data));
        }
        console.log(response);
      }),
      catchError(error => this.handleError(error))
    );

  }


  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }     
    // Return an observable with a user-facing error message.
    return throwError(
      'Something bad happened; please try again later.');
  }
}
