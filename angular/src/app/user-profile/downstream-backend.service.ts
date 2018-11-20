import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { doesNotThrow } from 'assert';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DownstreamBackendService {

_url = 'https://13.233.180.226:8097/downstream-service/matchmaker/v1/employees';

  constructor(private httpClient: HttpClient) { }

   getEmployee(employeeId: String) {
     const _url = this._url + '/' + employeeId;
     return this.httpClient.get(_url).pipe(catchError(this.errorHandler));
   }

   errorHandler(error: Error) {
     return throwError(error.message);
   }
}
