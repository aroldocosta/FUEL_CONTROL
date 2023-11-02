import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pump } from '../model/pump.model';

@Injectable({
  providedIn: 'root'
})
export class PumpService {
  baseUrl = "http://localhost:8080/pumps";

  constructor(private http: HttpClient) { }

  list() {
    const url = this.baseUrl;
    return this.http.get<Pump[]>(url, {});
  }
  
  totals() {
    const url = this.baseUrl + "/totals";
    return this.http.get(url, {});
  }

}



