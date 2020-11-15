import { Component } from '@angular/core';
import {Observable} from 'rxjs';
import { AuthenticationService } from 'src/app/authentication/services/authentication.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'frontend';
  isLoggedIn$: Observable<boolean>;
    constructor(private authService: AuthenticationService ) { }

    ngOnInit(): void {
      this.isLoggedIn$ = this.authService.isLoggedIn;
    }
}
