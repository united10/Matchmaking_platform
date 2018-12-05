import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { TokenStorageService } from 'src/app/login/service/token-storage.service';
import { Subject, Subscription } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { SpeechService } from '../../lib';
import { SearchService } from '../../service/search.service';
import { QueryData } from '../../domain/QueryData';
import {
  ComponentFactoryResolver, Type,
  ViewChild,
  ViewContainerRef
} from '@angular/core';
import { DisplayCardsComponent } from '../display-cards/display-cards.component';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import $ from 'jquery';
import { componentNeedsResolution } from '@angular/core/src/metadata/resource_loading';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit, OnDestroy {
  private serverUrl = 'https://matchmaker-zuul.stackroute.in/websocket-service/socket'
  private title = 'WebSockets chat';
  private stompClient;
  @ViewChild('container', {read: ViewContainerRef}) container: ViewContainerRef;

constructor(private tokenstorageservice: TokenStorageService,
    private fb: FormBuilder,
    private searchService: SearchService,
    public speech: SpeechService,
    private componentFactoryResolver: ComponentFactoryResolver) { }

  queryForm: FormGroup;
  userId: string;
  query: string;
  timeStamp: string;
  errorMessage = '';
  isLoggedIn = false;
  msg = '';
  context = '';
  subscription = Subscription.EMPTY;
  good: any;
  started = false;
  components=[];
  employeeName:any;
  email:any;
  draggableComponentClass =DisplayCardsComponent;
  emply:any;
  private _destroyed = new Subject<void>();

  createFormData(): FormGroup {
    return this.fb.group({
      query: ''
    });
  }

  submitQuery() {
    this.initializeWebSocketConnection();
  const queryData = new QueryData(this.userId, this.queryForm.get('query').value , this.timeStamp);
  this.searchService.submitQueryDetails(queryData).subscribe(
    data => {
      // console.log(data);
    },
    error => {
      this.errorMessage = error;
    });
  }

  ngOnInit() {
    if (this.tokenstorageservice.getToken()) {
        this.isLoggedIn = true;
      }

    this.queryForm = this.createFormData();
    this.speech.start();
    this.speech.message.pipe(
        takeUntil(this._destroyed)
    ).subscribe(msg => this.msg = msg.message);
    this.speech.context.pipe(
        takeUntil(this._destroyed)
    ).subscribe(context =>  this.context = context);
    this.good = {message: 'Try me!'};
    this.speech.started.pipe(
        takeUntil(this._destroyed)
    ).subscribe(started => this.started = started);


    
  }

ngOnDestroy(): void {
    this._destroyed.next();
    this._destroyed.complete();
    this.subscription.unsubscribe();
}

initializeWebSocketConnection(){
  // const componentFactory = this.componentFactoryResolver.resolveComponentFactory(this.draggableComponentClass);
  // const component = this.container.createComponent(componentFactory).instance;
  // component.employeeName=this.employeeName;
  // component.email=this.email;
  // // Push the component so that we can keep track of which components are created
  // this.components.push(component);
  let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/search/messages", (message) => {
        if(message.body) {
          let body=JSON.parse(message.body);
          let employees=body.employee;
          console.log(employees.name);
          that.employeeName=employees.name;
          that.email=employees.email;
          //that.employeeName=message.body.employee.name;
         that.addComponent(that.draggableComponentClass);
        }
      });
    });
    
}

toggleVoiceRecognition(): void {
    if (this.started) {
        this.speech.stop();
    } else {
        this.speech.start();
    }
}
  logout() {
    this.tokenstorageservice.signOut();
    window.location.reload();
  }

  addComponent(componentClass: Type<any>) {
    // Create component dynamically inside the ng-template
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(componentClass);
    const component = this.container.createComponent(componentFactory).instance;
    component.employeeName=this.employeeName;
    component.email=this.email;
    // Push the component so that we can keep track of which components are created
    this.components.push(component);
  }
}
