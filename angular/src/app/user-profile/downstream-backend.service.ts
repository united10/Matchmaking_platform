import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { doesNotThrow } from 'assert';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DownstreamBackendService {

_url="/matchmaker/v1/employees";

  constructor(private httpClient:HttpClient) { }

   getEmployee(employeeId:String){
     let _url=this._url+"/"+employeeId;
     return this.httpClient.get(_url).pipe(catchError(this.errorHandler));
   } 

   errorHandler(error:Error){
     return throwError(error.message);
   }
}
