import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import { AuthenticationService } from 'src/app/authentication/services/authentication.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  isLoggedIn$: Observable<boolean>;
  title = 'frontend';
    constructor(private authService: AuthenticationService ) { }

    ngOnInit(): void {
      this.isLoggedIn$ = this.authService.isLoggedIn;
    }
}
