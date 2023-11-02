import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fueling } from '../model/fueling.model';

@Injectable({
  providedIn: 'root'
})
export class FuelingsService {

  baseUrl = "http://localhost:8080/fuelings";

  constructor(private http: HttpClient) { }

  list() {
    const url = this.baseUrl;
    // return this.http.get(url, this.login.getHttpOptions());
    return this.http.get<Fueling[]>(url, {});
  }

  totals() {
    const url = this.baseUrl + "/totals";
    return this.http.get(url, {});
  }
}
