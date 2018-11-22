import { Component } from '@angular/core';
import { TokenStorageService } from './login/service/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'matchmaking';
  constructor(tokenStorageService: TokenStorageService , router: Router) {
    if (tokenStorageService.getToken()) {
      router.navigate(['home/user']);
    } else {
      router.navigate(['']);
    }
  }
}
