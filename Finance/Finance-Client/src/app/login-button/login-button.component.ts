import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { login_form } from '../shared/login';
@Component({
  selector: 'app-login-button',
  templateUrl: './login-button.component.html',
  styleUrls: ['./login-button.component.css']
})
export class LoginButtonComponent implements OnInit {
  fieldTextType: boolean = false;
  invalidLogin: boolean = false;
  submitted: boolean = false;
  userId: string = "";

  constructor(private _formBuilder: FormBuilder, private router: Router, private loginService: LoginService) { }

  ngOnInit(): void { }

  loginForm = this._formBuilder.group({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required, Validators.minLength(8), Validators.maxLength(12)])
  })

  get formValidation() {
    return this.loginForm.controls;
  }

  // password peek in login form
  toggleFieldTextType() {
    this.fieldTextType = !this.fieldTextType;
  }


  onSubmit() {

    let loginData: login_form = {
      customerUsername: this.loginForm.value.username,
      customerPassword: this.loginForm.value.password
    }

    console.log(loginData);
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }

    localStorage.setItem(this.userId,this.loginService.validUserWithId);
    return this.loginService.ValidateUser(loginData).subscribe((data: any) => console.log(data), (error: any) => console.log(error));

  }
}
