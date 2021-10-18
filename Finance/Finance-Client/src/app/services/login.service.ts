import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { login_form } from '../shared/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  validUserWithId: any;

  baseURL: string = "http://localhost:8282/login/login"
  constructor(private httpService: HttpClient) { }

  ValidateUser(login: login_form) {
    this.validUserWithId = this.httpService.post(this.baseURL, login);
    return this.validUserWithId;
  }

}
