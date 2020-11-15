import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { RegisterRequest } from '../../authentication/models';
import { UpdateInterest } from '../models/updateinterest.model';
import {UpdateProfile} from '../models/updateprofile.model'

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
  public getUserProfile(): Observable<any> {
    const user = JSON.parse(sessionStorage.getItem('user'));
    return this.http.get<any>(environment.baseUrl + "/v1/meet-greet/students/personal-details/" + user.id).pipe(
      catchError(error => this.handleError(error))
    );
  }
  public updateUserProfile(update :UpdateProfile): Observable<any>{
    const user = JSON.parse(sessionStorage.getItem('user'));
    return this.http.put<any>(environment.baseUrl+"/v1/meet-greet/students/personal-details/"+ user.id,update).pipe(
      catchError(error => this.handleError(error))
    );
    
  }
  public getUserInterests(): Observable<any> {
    const user = JSON.parse(sessionStorage.getItem('user'));
    return this.http.get<any>(environment.baseUrl + "/v1/meet-greet/students/interests/" + user.id).pipe(
      catchError(error => this.handleError(error))
    );
  }
  public updateUserInerests(update: UpdateInterest):Observable<any>{
    const user = JSON.parse(sessionStorage.getItem('user'));
    console.log(user.id,update);
    return this.http.put<any>(environment.baseUrl+"/v1/meet-greet/students/interests/"+ user.id,update).pipe(
      catchError(error => this.handleError(error))
    );
  }
  private handleError(error: HttpErrorResponse) {
    return throwError(
      'Something bad happened; please try again later.');
  }
}
