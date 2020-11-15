import { Injectable } from '@angular/core';
import { HttpService } from 'src/app/shared/services/http.service';
import { LoginRequest } from '../models';
import {AnnouncementRequest} from '../models';
import { RegisterRequest } from '../models';
//import { PairupRequest } from 'src/app/match-making/models';
import { Observable, throwError, BehaviorSubject } from 'rxjs';
import { HttpClient, HttpErrorResponse } from '@angular/common/http'
import { environment } from 'src/environments/environment';
import { catchError, map, tap } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  get isLoggedIn() {
      return this.loggedIn.asObservable();
    }
  constructor(private http: HttpClient) {

  }
  public announcementId: number;
  public studentID: number;
  public loginAuthentication(request: LoginRequest): Observable<any> {
    return this.http.post<any>(environment.baseUrl + "/v1/meet-greet/students/login", request).pipe(
      tap(response => {
        if (!(response.message)) {
          this.loggedIn.next(true);
          sessionStorage.setItem('user', JSON.stringify(response));
          //sessionStorage.setItem('navflag', true);
        }
      }),
      catchError(error => this.handleError(error))
    );
  }

  public makeAnnouncement(request: AnnouncementRequest): Observable<any> {

    return this.http.post<any>(environment.baseUrl + "/v1/meet-greet/students/announcement", request).pipe(
      tap(response => {
      this.announcementId = response.id;
      console.log(this.announcementId);
      })
    );
  }

  public getStudents(studentId: number): Observable<any>{
        return this.http.get<any>(environment.baseUrl + "/v1/meet-greet/students?studentId="+studentId).pipe(
          tap(response => {
          console.log('response for get students api',response);
          })
        );
  }
  isUserLoggedIn() {
    return sessionStorage.getItem('user');
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

  public getLoggedUserDetails(studentID: number): Observable<any>{
    return this.http.get<any>(environment.baseUrl + "/v1/meet-greet/students/"+studentID).pipe(
    tap(response =>{
     console.log('logged user details=',  response);
          }),
          catchError(error => this.handleError(error))
        )
  }

 /* public registerTimeslots(pairupRequest :PairupRequest):Observable<any>{
      return this.http.post<any>(environment.baseUrl+"/v1/meet-greet/students/pairup",pairupRequest).pipe(
        tap(response =>{
        }),
        catchError(error => this.handleError(error))
      )
    }*/

}
