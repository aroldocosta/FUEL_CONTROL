import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../model/user.model';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public counter = 1;
  
  constructor(private http: HttpClient, private login: LoginService) {}
  
  readonly baseUrl = environment.API_BASE_URL;

  list() {
    const url = `${this.baseUrl}users`;
    return this.http.get(url, this.login.getHttpOptions());
  }

  get(id: string) {
    const url = `${this.baseUrl}users/${id}`;
    return this.http.get(url, this.login.getHttpOptions());
  }

  // create(user: any): Observable<any> {
  //   const url = `${this.baseUrl}users`;
  //   return this.http.post(url, user, this.login.getHttpOptions());
  // }

  // update(user: any): Observable<any> {
  //   const url = `${this.baseUrl}users`;
  //   return this.http.put(url, user, this.login.getHttpOptions());
  // }

  // remove(id: any): Observable<any> {
  //   const url = `${this.baseUrl}users/${id}`;
  //   return this.http.delete(url, this.login.getHttpOptions());
  // }
}