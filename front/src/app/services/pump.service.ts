import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Pump } from '../model/pump.model';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class PumpService {

  readonly baseUrl = environment.API_BASE_URL;

  constructor(private http: HttpClient, private login: LoginService) { }

  list() {
    const url = `${this.baseUrl}pumps`;
    return this.http.get<Pump[]>(url, this.login.getHttpOptions());
  }
  
  totals() {
    const url = `${this.baseUrl}totals`;
    return this.http.get(url, this.login.getHttpOptions());
  }

}



