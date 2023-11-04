import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpResponse } from '@capacitor/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  baseUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  report() {
    const url = this.baseUrl + '/report';
    return this.http.get(url, { responseType: 'blob' });
  }
 }
