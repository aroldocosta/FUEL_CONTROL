import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Tank } from '../model/tank.modal';

@Injectable({
  providedIn: 'root'
})
export class TankService {

  readonly baseUrl = environment.API_BASE_URL;
  constructor(private http: HttpClient) { }

  list() {
    const url = `${this.baseUrl}tanks`;
    return this.http.get<Tank[]>(url, {});
  }
}