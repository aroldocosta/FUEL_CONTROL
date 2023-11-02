import { ThisReceiver } from '@angular/compiler';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Pump } from 'src/app/model/pump.model';
import { Tank } from 'src/app/model/tank.modal';
import { User } from 'src/app/model/user.model';
// import { PageComponent } from 'src/app/pages/page/page.component';
import { LoginService } from 'src/app/services/login.service';
import { PumpService } from 'src/app/services/pump.service';
import { TankService } from 'src/app/services/tank.service';
// import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
 
  @Output() tankEvent = new EventEmitter<Tank[]>();
  @Output() pumpEvent = new EventEmitter<Pump[]>();
  logged: any = new User();

  constructor(
    private tankService: TankService,
    private pumpService: PumpService,
    private login: LoginService, 
    private router: Router) {
  }

  ngOnInit(): void {
    
    const userId = this.login.getAuthId();

    // if(this.login.getAuthData() != null) {
    //   this.userService.get(userId).subscribe({
    //     next: user => {
    //       this.logged = user;
    //     },
    //     error: err => {
    //       this.login.setAuthData(null);
    //     }
    //   })
    // } else {
    //   this.login.setAuthData(null);
    // }
    this.logged.name = 'Usuario Teste';
  }

  requestPumps() {
    this.pumpService.list().subscribe(list => {
      this.pumpEvent.emit(list);
    })
  }

  requestTanks() {
    this.tankService.list().subscribe(list => {
      for(let t of list) {
        console.log(t.fuel);
      }
      this.tankEvent.emit(list);
    })
  }

  // sendPumpListToParent(list: Pump[]) {
  //   for(let l of list) {
  //     console.log(l.name);
  //   }
  //   this.pumpEventsendPumpList.emit(list);
  // }

  getId() {
    return this.login.getAuthId();
  }

  getToken() {
    return this.login.getAuthToken();
  }

  // override isAuthenticated() {
    // return this.login.isAuthenticated();
  // }

  isAuthenticated() {
    return !true;
  }

  contact() {
    // this.goToLink("/contact", this.login, this.router);
  }

  about() {
    // this.goToLink("/about", this.login, this.router);
  }

  test() {
    // this.goToLink("/test", this.login, this.router);
  }

  loginForm() {
    // this.goToLink("/login", this.login, this.router);
  }

  logout() {
    // this.goToLink("/logout", this.login, this.router);
  }

  list() {
    // this.goToLink("/users/list", this.login, this.router);
  }

  userData() {
    //let url = "/users/data/" + this.logged.id;
    // this.goToLink(url, this.login, this.router);
  }
}
