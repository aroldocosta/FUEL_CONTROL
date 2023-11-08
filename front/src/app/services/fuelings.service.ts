import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Fueling } from '../model/fueling.model';
import { LoginComponent } from '../pages/login/login.component';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class FuelingsService {

  readonly baseUrl = environment.API_BASE_URL;

  constructor(private http: HttpClient, private login: LoginService) { }

  list() {
    const url = `${this.baseUrl}fuelings`;
    return this.http.get<Fueling[]>(url, this.login.getHttpOptions());
  }

  get(id: number) {
    const url = `${this.baseUrl}fuelings/${id}`;
    return this.http.get<Fueling>(url, {});
  }
  
  create(fueling: any): Observable<any> {
    const url = `${this.baseUrl}fuelings`;
    return this.http.post(url, fueling, this.login.getHttpOptions());
  }

  update(fueling: Fueling): Observable<any> {
    const url = `${this.baseUrl}fuelings`;
    return this.http.put(url, fueling, this.login.getHttpOptions());
  }

  remove(id: any): Observable<any> {
    const url = `${this.baseUrl}fuelings/${id}`;
    return this.http.delete(url, this.login.getHttpOptions());
  }

  totals() {
    const url = `${this.baseUrl}fuelings/totals`;
    return this.http.get(url, this.login.getHttpOptions());
  }
}
