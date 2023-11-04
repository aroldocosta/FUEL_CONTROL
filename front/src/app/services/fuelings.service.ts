import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Fueling } from '../model/fueling.model';

@Injectable({
  providedIn: 'root'
})
export class FuelingsService {

  readonly baseUrl = environment.API_BASE_URL;

  constructor(private http: HttpClient) { }

  list() {
    const url = `${this.baseUrl}fuelings`;
    return this.http.get<Fueling[]>(url, {});
  }

  totals() {
    const url = `${this.baseUrl}fuelings/totals`;
    return this.http.get(url, {});
  }
}
