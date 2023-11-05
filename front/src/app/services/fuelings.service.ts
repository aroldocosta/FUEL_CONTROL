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


  get(id: number) {
    const url = `${this.baseUrl}fuelings/${id}`;
    return this.http.get<Fueling>(url, {});
  }
  
  create(fueling: any): Observable<any> {
    const url = `${this.baseUrl}fuelings`;
    return this.http.post(url, fueling, this.options);
  }

  update(fueling: Fueling): Observable<any> {
    const url = `${this.baseUrl}fuelings`;
    return this.http.put(url, fueling, this.options);
  }

  remove(id: any): Observable<any> {
    const url = `${this.baseUrl}fuelings/${id}`;
    return this.http.delete(url, this.options);
  }

  totals() {
    const url = `${this.baseUrl}fuelings/totals`;
    return this.http.get(url, {});
  }
}
