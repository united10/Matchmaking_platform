import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { TokenStorageService } from 'src/app/login/service/token-storage.service';
import { Subject, Subscription } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { SpeechService } from '../../lib';
import { SearchService } from '../../service/search.service';
import { QueryData } from '../../domain/QueryData';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit, OnDestroy {

constructor(private tokenstorageservice: TokenStorageService,
    private fb: FormBuilder,
    private searchService: SearchService,
    public speech: SpeechService) { }

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

  private _destroyed = new Subject<void>();

  createFormData(): FormGroup {
    return this.fb.group({
      query: ''
    });
  }

  submitQuery() {
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
}
