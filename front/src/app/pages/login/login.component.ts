
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TopMessageComponent } from 'src/app/components/top-message/top-message.component';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm!: FormGroup;
  @ViewChild(TopMessageComponent) topMessage?: TopMessageComponent;

  constructor(private service: LoginService, private router: Router) {}

  ngOnInit(): void {
    this.service.setAuthData(null);
    this.loginForm = new FormGroup({
      login: new FormControl('aroldocosta@yahoo.com.br',[Validators.required]),
      password: new FormControl('89c2051', [Validators.required]),
    })
  }

  get login() {
    return this.loginForm.get('login')!;
  }

  get password() {
    return this.loginForm.get('password')!;
  }


  onSubmit() {
    let login = this.login.value;
    let password = this.password.value
    this.router.navigateByUrl("/");

     this.service.resquestLogin(login, password)
     .subscribe({
        next: ( auth ) => {
          if(auth.token) {
            this.service.setAuthData(auth);
            this.router.navigateByUrl("/");
          } else {
            this.router.navigateByUrl("/login");
            this.topMessage?.setAlertMessage("Token de autenticação inválido!", 4500);
          }
        },
        error: ( err ) => {
          console.log("Erro de autenticação: " + err.message);
          this.topMessage?.setAlertMessage("Erro de autenticação!", 4500);
        }
     });
  }
}
