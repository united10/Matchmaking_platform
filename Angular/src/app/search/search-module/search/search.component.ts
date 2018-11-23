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
    const s1 = this._renderer2.createElement('script');
        s1.type = `application/ld+json`;
        s1.text = `
            {
                "@context": "/p5.js"
            }
        `;
        const s2 = this._renderer2.createElement('script');
        s2.type = `application/ld+json`;
        s2.text = `
            {
                "@context": "./p5/addons/p5.dom.js"
            }
        `;
        const s3 = this._renderer2.createElement('script');
        s3.type = `application/ld+json`;
        s3.text = `
            {
                "@context": "./p5/addons/p5.sound.js"
            }
        `;
        const s4 = this._renderer2.createElement('script');
        s4.type = `application/ld+json`;
        s4.text = `
            {
                "@context": "./p5/addons/p5.speech.js"
            }
        `;
        const s5 = this._renderer2.createElement('script');
        s5.type = `application/ld+json`;
        s5.text = `
            {
                "@context": "./p5/sketch.js"
            }
        `;

        this._renderer2.appendChild(this._document.body, s1);
        this._renderer2.appendChild(this._document.body, s2);
        this._renderer2.appendChild(this._document.body, s3);
        this._renderer2.appendChild(this._document.body, s4);
        this._renderer2.appendChild(this._document.body, s5);
  }
  logout() {
    this.tokenstorageservice.signOut();
    window.location.reload();
  }
}
