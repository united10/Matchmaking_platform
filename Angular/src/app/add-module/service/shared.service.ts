import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { TokenStorageService } from 'src/app/login/service/token-storage.service';
import { BehaviorSubject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SharedService {
  employee: any;
  employeeId = this.token.getEmail();

  constructor(private token: TokenStorageService) {}
  public subject = new BehaviorSubject(this.employee);

  errorHandler(error: Error) {
    return throwError(error.message);
  }

}
