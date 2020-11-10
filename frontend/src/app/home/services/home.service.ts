import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { RegisterRequest } from '../../authentication/models';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient) { }

  public getUserInfo(): Observable<any> {
    const user = JSON.parse(sessionStorage.getItem('user'));
    return this.http.get<any>(environment.baseUrl + "/v1/meet-greet/students/" + user.id).pipe(
      catchError(error => this.handleError(error))
    );
  }
  public updateUserProfile(register :RegisterRequest): Observable<any>{
    const user = JSON.parse(sessionStorage.getItem('user'));
    return this.http.put<any>(environment.baseUrl+"/v1/meet-greet/students/", user.id +register).pipe(
      catchError(error => this.handleError(error))
    );
    
  }

  private handleError(error: HttpErrorResponse) {
    return throwError(
      'Something bad happened; please try again later.');
  }
}
