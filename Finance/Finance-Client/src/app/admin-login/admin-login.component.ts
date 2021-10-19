import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminLoginService } from '../services/admin-login.service';
import { admin_login_form } from '../shared/adminLogin';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  adminFieldTextType: boolean = false;
  invalidLogin: boolean = false;
  submitted: boolean = false;

  constructor(private _formBuilder: FormBuilder, private _router: Router, private adminLoginService: AdminLoginService) { }

  ngOnInit(): void { }

  adminLoginForm = this._formBuilder.group({
    admin_name: new FormControl('', [Validators.required]),
    admin_password: new FormControl('', [Validators.required, Validators.minLength(8), Validators.maxLength(12)])
  })


  get adminFormValidation() {
    return this.adminLoginForm.controls;
  }

  adminToggleFieldTextType() {
    this.adminFieldTextType = !this.adminFieldTextType;
  }

  adminOnSubmit() {
    let adminLoginData: admin_login_form = {
      adminUsername: this.adminLoginForm.value.admin_name,
      adminPassword: this.adminLoginForm.value.admin_password
    }

    console.log(adminLoginData);
    this.submitted = true;
    if (this.adminLoginForm.invalid) {
      return;
    }
    this.adminLoginService.validateAdmin(adminLoginData).subscribe(data =>
      sessionStorage.setItem("validAdminWithId", JSON.stringify(data)), error => console.log(error));
  }
}
