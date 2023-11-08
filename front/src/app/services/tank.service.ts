import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Tank } from '../model/tank.modal';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class TankService {

  readonly baseUrl = environment.API_BASE_URL;
  constructor(private http: HttpClient, private login: LoginService) { }

  list() {
    const url = `${this.baseUrl}tanks`;
    return this.http.get<Tank[]>(url, this.login.getHttpOptions());
  }
}