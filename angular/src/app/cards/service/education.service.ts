import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { EducationSection } from '../educationclasses/educationsection';
import { Output } from '../outputclass/output';
import { ExperienceSection } from '../experience-class/section';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})
export class EducationService {

<<<<<<< HEAD
  url: string = "/api/v1/education/";
  url1 = '/api/v1/experience/';
=======
  url = '/api/v1/education/';

>>>>>>> 9e7726043531d9d4e524b8a080637846f68a9cb7
  constructor(private httpClient: HttpClient) { }

  addEducationDetails(section: EducationSection): Observable<Output> {
    return this.httpClient.post<Output>(this.url, section, httpOptions).pipe(catchError(this.errorHandler));
  }
  addExperienceDetails(section: ExperienceSection): Observable<Output> {
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
