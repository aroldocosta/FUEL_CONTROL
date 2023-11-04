import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AuthenticationDTO } from '../model/authentication.model';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  user!: User;
  readonly baseUrl = environment.API_BASE_URL;

  constructor(private http: HttpClient) { }

  public resquestLogin(login: string, password: string): Observable<any> {
    const url = `${this.baseUrl}auth/login`;
    let authentication: AuthenticationDTO = new AuthenticationDTO(login, password);
    return this.http.post(url, authentication, {});
  }

  getAuthData() {
    let auth = window.localStorage.getItem("auth_data");
    return (auth) ? JSON.parse(auth) : null;
  }

  setAuthData(data: any | null) {
    if(data != null) {
      window.localStorage.setItem("auth_data", JSON.stringify(data));
    } else {
      window.localStorage.removeItem("auth_data");
    }
  }

  getAuthToken() : string {
    return  ( this.getAuthData() ) ? this.getAuthData().token : "";
  }

  getAuthId() : string {
    return  ( this.getAuthData() ) ? this.getAuthData().userId : "";
  }

  isAuthenticated() {
    return (this.getAuthData() !== null);
  }

  getHttpOptions() {
    let options = { 
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${this.getAuthToken()}`
      })
    };
    return options;
  }
}
