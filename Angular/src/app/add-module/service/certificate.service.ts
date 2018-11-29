import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { CertificateSection } from '../certificate-dialog/domain/certificatesection';
import { Observable, throwError } from 'rxjs';
import { CertificateResponse, Certi } from '../certificate-dialog/domain/Certi';
import { AuthorityResponse, Authority } from '../certificate-dialog/domain/Authority';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class CertificateService {

  url = 'https://matchmaker-zuul.stackroute.in/upstream-service/api/v1/certificate';

  constructor(private httpClient: HttpClient) { }

  addCertificateDetails(section: CertificateSection): Observable<CertificateSection> {
    return this.httpClient.post<CertificateSection>(this.url, section, httpOptions).pipe(catchError(this.errorHandler));
  }

  errorHandler(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError('Something bad happened; please try again later.');
  }
  search(filter: {name: string} = {name: ''}, page = 1): Observable<CertificateResponse> {
    console.log('inside service ' + filter.name);
    return this.httpClient.get<CertificateResponse>('http://172.23.239.135:8081/api/v1/redisEducation/' + filter.name)
    .pipe(
      tap((response: CertificateResponse) => {
        response.certifications = response.certifications
          .map(certi => new Certi(certi.name, certi.id));
        return response;
      })
      );
  }
  search1(filter: {name: string} = {name: ''}, page = 1): Observable<AuthorityResponse> {
    console.log('inside service ' + filter.name);
    return this.httpClient.get<AuthorityResponse>('http://172.23.239.135:8081/api/v1/redisEducation/' + filter.name)
    .pipe(
      tap((response: AuthorityResponse) => {
        response.authorities = response.authorities
          .map(authority => new Authority(authority.name, authority.id));
        return response;
      })
      );
  }
}
