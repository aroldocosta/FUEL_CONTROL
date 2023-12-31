import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  readonly baseUrl = environment.API_BASE_URL;

  headers = new HttpHeaders({
    'Authorization': `Bearer ${this.login.getAuthToken()}`
  });

  constructor(private http: HttpClient, private login: LoginService) { }

  report() {
    const url = `${this.baseUrl}report`;
    return this.http.get(url, { responseType: 'blob', headers: this.headers });
  }
 }
