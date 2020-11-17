import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { RegisterRequest } from '../../authentication/models';
import { UpdateInterest } from '../models/updateinterest.model';
import {UpdateProfile} from '../models/updateprofile.model';
import {RegisterTimeSlots} from '../../match-making/models/registertimeslots.model';
import { UpdateInterestsRequest } from '../models/updateInterestsRequest.model';

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

  public registerUserTimeSlot(timeslot :RegisterTimeSlots): Observable<any>{
    return this.http.post<any>(environment.baseUrl+"/v1/meet-greet/students/pairup",timeslot).pipe(
      catchError(error => this.handleError(error))
    );
    
  }
<<<<<<< HEAD
  public updateUserInerests(update: UpdateInterestsRequest):Observable<any>{
=======
  public getUserTimeSlot(): Observable<any>{
    const user = JSON.parse(sessionStorage.getItem('user'));
    return this.http.get<any>(environment.baseUrl+"/v1/meet-greet/students/pairup?studentId="+ user.id).pipe(
      catchError(error => this.handleError(error))
    );
    
  }
  public updateUserInerests(update: UpdateInterest):Observable<any>{
>>>>>>> integration and validation of view time slots
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
