import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  readonly baseUrl = environment.API_BASE_URL;

  constructor(private http: HttpClient) { }

  report() {
    const url = `${this.baseUrl}report`;
    return this.http.get(url, { responseType: 'blob' });
  }
 }
