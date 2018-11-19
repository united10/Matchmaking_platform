import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { ExperienceSection } from '../experience-class/section';
import { Output } from '../experience-class/output';
import { catchError } from 'rxjs/operators';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ExperienceService {

  url1 = 'http://13.233.180.226:8097/upstream-service/api/v1/experience/';
  constructor(private httpClient: HttpClient) { }

  addExperienceDetails(section: ExperienceSection): Observable<Output> {
    console.log(section);
    return this.httpClient.post<Output>(this.url1, section, httpOptions).pipe(catchError(this.errorHandler));
  }
  errorHandler(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError('Something bad happened; please try again later.');
  }
}
