import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { ProjectSection } from '../project-dialog/domain/projectsection';
import { Observable, throwError } from 'rxjs';
import { DomainResponse, Domain } from '../project-dialog/domain/domain';
import { OrganisationResponse, Organisation } from '../project-dialog/domain/organisation';
import { ClientResponse, Client } from '../project-dialog/domain/client';
import { TechResponse, Tech } from '../project-dialog/domain/Tech';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  url = 'https://matchmaker-zuul.stackroute.in/upstream-service/api/v1/project';

  constructor(private httpClient: HttpClient) { }

  addProjectDetails(section: ProjectSection): Observable<ProjectSection> {
    return this.httpClient.post<ProjectSection>(this.url, section, httpOptions).pipe(catchError(this.errorHandler));
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
  searchdomain(filter: {name: string} = {name: ''}, page = 1): Observable<DomainResponse> {
    return this.httpClient.get<DomainResponse>('http://13.233.180.226:8008/api/v1/redisDomain/' + filter.name)
    .pipe(
      tap((response: DomainResponse) => {
        response.domains = response.domains
          .map(domain => new Domain(domain.name, domain.id))
          .filter(currentcities => currentcities.name.includes(filter.name));
        return response;
      })
      );
  }
  searchtcompany(filter: {name: string} = {name: ''}, page = 1): Observable<OrganisationResponse> {
    console.log('inside service ' + filter.name);
    return this.httpClient.get<OrganisationResponse>('http://172.23.239.135:8081/api/v1/redisEducation/' + filter.name)
    .pipe(
      tap((response: OrganisationResponse) => {
        response.organisations = response.organisations
          .map(organisation => new Organisation(organisation.name, organisation.id));
        return response;
      })
      );
  }
  searchclient(filter: {name: string} = {name: ''}, page = 1): Observable<ClientResponse> {
    console.log('inside service ' + filter.name);
    return this.httpClient.get<ClientResponse>('http://172.23.239.135:8081/api/v1/redisEducation/' + filter.name)
    .pipe(
      tap((response: ClientResponse) => {
        response.clients = response.clients
          .map(client => new Client(client.name, client.id));
        return response;
      })
      );
  }
  searchtech(filter: {name: string} = {name: ''}, page = 1): Observable<TechResponse> {
    console.log('inside service ' + filter.name);
    return this.httpClient.get<TechResponse>('http://172.23.239.135:8081/api/v1/redisEducation/' + filter.name)
    .pipe(
      tap((response: TechResponse) => {
        response.technologies = response.technologies
          .map(tech => new Tech(tech.name, tech.id));
        return response;
      })
      );
  }
}
