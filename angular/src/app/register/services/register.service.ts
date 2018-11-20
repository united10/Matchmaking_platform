import { Injectable } from '@angular/core';
import { RegisterModel } from '../models/register.model';
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders
} from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private _url = 'https://13.233.180.226:8097/registration-service/api/v1/registration/user';
  constructor(private _http: HttpClient) {}

  submit(user: RegisterModel): Observable<RegisterModel> {
    return this._http
      .post<RegisterModel>(this._url, user, httpOptions)
      .pipe(catchError(this.errorHandler));
  }
  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}
