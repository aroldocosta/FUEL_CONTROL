import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user.model';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-commons',
  templateUrl: './commons.component.html',
  styleUrls: ['./commons.component.css']
})
export class CommonsComponent {

  formData?: any;
  logged: any = new User();
  errors = "";
  DUPLICATED_KEY = "DUPLICATED_KEY";
  UNKNOWN_ERROR  = "UNKNOWN_ERROR";

  constructor() {

  }

  goToLink(link: string, login: LoginService, router: Router) {
    if(link == "/logout") {
      login.setAuthData(null);
      router.navigateByUrl("/login");
    } else {
      router.navigateByUrl(link);
    } 
  }

  isAuthenticated(login: LoginService, router: Router): boolean {
    if(!login.isAuthenticated()) {
      router.navigateByUrl("/login");
      return false;
    } else {
      return true;
    }
  }
}