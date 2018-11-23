import { Component, OnInit } from '@angular/core';
import { Renderer2, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/platform-browser';
import { TokenStorageService } from 'src/app/login/service/token-storage.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private _renderer2: Renderer2,
    private tokenstorageservice: TokenStorageService,
     @Inject(DOCUMENT) private _document) { }

  isLoggedIn = false;

  ngOnInit() {
    if (this.tokenstorageservice.getToken()) {
        this.isLoggedIn = true;
      }
  }
  logout() {
    this.tokenstorageservice.signOut();
    window.location.reload();
  }
}
