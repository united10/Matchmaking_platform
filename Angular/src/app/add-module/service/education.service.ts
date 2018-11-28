import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { EducationSection } from '../education-dialog/domain/educationsection';
import { Output } from '../outputclass/output';
import { IQualificationResponse, Qualificationn } from '../education-dialog/domain/qualificationn';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})
export class EducationService {

  url = 'http://13.233.180.226:8097/upstream-service/api/v1/education/';

  constructor(private httpClient: HttpClient) { }

  addEducationDetails(section: EducationSection): Observable<Output> {
    return this.httpClient.post<Output>(this.url, section, httpOptions).pipe(catchError(this.errorHandler));
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
  search(filter: {name: string} = {name: ''}, page = 1): Observable<IQualificationResponse> {
    console.log('inside service ' + filter.name);
    return this.httpClient.get<IQualificationResponse>('http://172.23.239.135:8081/api/v1/redisEducation/' + filter.name)
    .pipe(
      tap((response: IQualificationResponse) => {
        response.educations = response.educations
          .map(qualification => new Qualificationn(qualification.name, qualification.id));
        return response;
      })
      );
  }
}
