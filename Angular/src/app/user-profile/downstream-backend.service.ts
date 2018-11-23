import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { doesNotThrow } from 'assert';
import { throwError } from 'rxjs';
import { EducationSection } from '../add-module/education-dialog/domain/educationsection';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};


@Injectable({
  providedIn: 'root'
})
export class DownstreamBackendService {

_url = 'http://13.233.180.226:8097/downstream-service/matchmaker/v1/employees';
delete_url = 'http://13.233.180.226:8097/upstream-service/api/v1/education/';

  constructor(private httpClient: HttpClient) { }

   getEmployee(employeeId: String) {
     const _url = this._url + '/' + employeeId;
     return this.httpClient.get(_url).pipe(catchError(this.errorHandler));
   }

   errorHandler(error: Error) {
     return throwError(error.message);
   }

  deleteEducationDetails(section: EducationSection){
    return this.httpClient.post<any>(this.delete_url, section, httpOptions).pipe(catchError(this.errorHandler));
  }
}
