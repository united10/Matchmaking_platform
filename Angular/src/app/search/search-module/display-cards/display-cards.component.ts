import { Component, OnInit, Input } from '@angular/core';
import { EmailValidator } from '@angular/forms';

@Component({
  selector: 'app-display-cards',
  templateUrl: './display-cards.component.html',
  styleUrls: ['./display-cards.component.css']
})
export class DisplayCardsComponent implements OnInit {

  @Input() employeeName:any;
  @Input() email:any;

  constructor() { }

  ngOnInit() {
  }

}
