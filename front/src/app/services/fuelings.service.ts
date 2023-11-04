import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Fueling } from '../model/fueling.model';

@Injectable({
  providedIn: 'root'
})
export class FuelingsService {

  readonly baseUrl = environment.API_BASE_URL;

  token = "tokendeteste";

  options = { 
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  list() {
    const url = `${this.baseUrl}fuelings`;
    return this.http.get<Fueling[]>(url, {});
  }


  get(id: string) {
    const url = `${this.baseUrl}fuelings/${id}`;
    return this.http.get(url, {});
  }
  
  create(fueling: any): Observable<any> {
    const url = `${this.baseUrl}fuelings`;

    console.log("Url: " + JSON.stringify(url) + "\nHeaders: " + JSON.stringify(this.options));

    return this.http.post(url, fueling, this.options);
  }
/*
  update(user: any): Observable<any> {
    const url = this.baseUrl + "/" + user.id;
    return this.http.put(url, user, this.login.getHttpOptions());
  }
*/
  remove(id: any): Observable<any> {
    const url = `${this.baseUrl}fuelings/${id}`;
    return this.http.delete(url, this.options);
  }

  totals() {
    const url = `${this.baseUrl}fuelings/totals`;
    return this.http.get(url, {});
  }
}
