import { ThisReceiver } from '@angular/compiler';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Pump } from 'src/app/model/pump.model';
import { Tank } from 'src/app/model/tank.modal';
import { User } from 'src/app/model/user.model';
// import { PageComponent } from 'src/app/pages/page/page.component';
import { LoginService } from 'src/app/services/login.service';
import { PumpService } from 'src/app/services/pump.service';
import { ReportService } from 'src/app/services/report.service';
import { TankService } from 'src/app/services/tank.service';
import { UserService } from 'src/app/services/user.service';
import { CommonsComponent } from '../commons/commons.component';
// import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent extends CommonsComponent implements OnInit{
 
  @Output() tankEvent   = new EventEmitter<Tank[]>();
  @Output() pumpEvent   = new EventEmitter<Pump[]>();
  @Output() reportEvent = new EventEmitter<any>();

  constructor(
    private tankService: TankService,
    private pumpService: PumpService,
    private userService: UserService,
    private reportService: ReportService,
    private router: Router,
    private login: LoginService) {
      super();
  }

  ngOnInit(): void {
    
    const userId = this.login.getAuthId();

    if(this.login.getAuthData() != null) {
      this.userService.get(userId).subscribe({
        next: user => {
          this.logged = user;
        },
        error: err => {
          this.login.setAuthData(null);
          this.goToLink('/login', this.login, this.router);
        }
      })
    } else {
      this.login.setAuthData(null);
      this.goToLink('/login', this.login, this.router);
    }
  }

  requestPumps() {
    this.pumpService.list().subscribe({
      next: list => {
        debugger
        this.pumpEvent.emit(list);
      },
      error: err => {
        debugger
        this.goToLink('/login', this.login, this.router);
      }
    })
  }

  requestTanks() {
    this.tankService.list().subscribe(list => {
      this.tankEvent.emit(list);
    })
  }

  requestReport(){
    this.reportService.report().subscribe(report => {
      this.reportEvent.emit(report);
    })
  }

  getId() {
    return this.login.getAuthId();
  }

  getToken() {
    return this.login.getAuthToken();
  }


  override isAuthenticated() {
    return this.login.isAuthenticated();
  }

  loginForm() {
     this.goToLink("/login", this.login, this.router);
  }

  logout() {
     this.goToLink("/logout", this.login, this.router);
  }

  userData() {

  }
}
