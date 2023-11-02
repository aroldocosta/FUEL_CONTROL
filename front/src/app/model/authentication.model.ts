export class AuthenticationDTO {

    login = "";
    password = "";

    constructor(login: string, password: string) {
        this.login = login;
        this.password = password;
    }
}