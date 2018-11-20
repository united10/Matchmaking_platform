import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from 'src/app/login/service/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLoggedIn = false;
  constructor(private tokenstorageservice: TokenStorageService) { }


  ngOnInit() {
    if (this.tokenstorageservice.getToken()) {
      this.isLoggedIn = true;
    }
  }
  logout() {
    this.tokenstorageservice.signOut();
  }
}
