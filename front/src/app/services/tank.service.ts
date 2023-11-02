import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tank } from '../model/tank.modal';

@Injectable({
  providedIn: 'root'
})
export class TankService {

  baseUrl = "http://localhost:8080/tanks";
  constructor(private http: HttpClient) { }

  list() {
    const url = this.baseUrl;
    return this.http.get<Tank[]>(url, {});
  }
}