import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { TokenStorageService } from 'src/app/login/service/token-storage.service';
import { BehaviorSubject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DownstreamService {
  employee: any;
  employeeId = this.token.getEmail();

  constructor(private httpClient: HttpClient, private token: TokenStorageService) {
    // const employeeId = this.token.getEmail();
    // const _url = 'https://matchmaker-zuul.stackroute.in/downstream-service/matchmaker/v1/employees' + '/' + employeeId;
    // this.employee = this.httpClient.get(_url).pipe(catchError(this.errorHandler));
  }
  public subject = new BehaviorSubject(this.employee);

  errorHandler(error: Error) {
    return throwError(error.message);
  }

}
