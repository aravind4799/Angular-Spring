import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { ForgotPasswordService } from '../services/forgot-password.service';
import { send_password } from '../shared/forgot-password';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  sendOTPButton: boolean = false;
  email: string = "";
  new_password: string = "";
  confirm_password: string = "";
  userIdandOTP: string = "";
  temp: string = "";
  otp: string = "";
  wrongOTP: boolean = false;
  enableVerify: boolean = true;
  valid: boolean = false;
  notValidEmail: boolean = false;
  enableOTPbutton: boolean = false;
  fieldTextType: boolean = false;

  constructor(private _formBuilder: FormBuilder, private router: Router, private forgotPasswordService: ForgotPasswordService) { }

  ngOnInit(): void {
  }
  toggleFieldTextType() {
    this.fieldTextType = !this.fieldTextType;
  }

  Form = this._formBuilder.group({
    new_password: new FormControl('', [Validators.required]),
    confirm_password: new FormControl('', [Validators.required, Validators.minLength(8),Validators.pattern(this.new_password)])
  })

  sendOTPActionButton() {
    this.forgotPasswordService.sendOTPActionButton(this.email).subscribe(data =>
      sessionStorage.setItem("userIdandOTP", JSON.stringify(data)), error => console.log(error));
    let res: string = JSON.stringify(sessionStorage.getItem("userIdandOTP"));
    // console.log(typeof(res))
    console.log(res)
    if (sessionStorage.getItem('userIdandOTP')==='null' || sessionStorage.getItem('userIdandOTP')===null) {
      this.enableOTPbutton = false;
      console.log("if")
    }
    else {
      this.notValidEmail = true;
      console.log("else")
    }
  }

  checkOTP() {
    this.wrongOTP = false;
    let res = JSON.stringify(sessionStorage.getItem("userIdandOTP"));
    if (res != "") {
      let userId = parseInt(sessionStorage.getItem("userIdandOTP")!.split('.')[0]);
      let otpId = sessionStorage.getItem("userIdandOTP")!.split('.')[1];
      console.log(userId);
      console.log(otpId);

      if (otpId == this.otp) {
        this.enableVerify = false;
        this.valid = true;
      }
      else {
        this.wrongOTP = true;
      }
    }
  }

  updatePassword() {
    let res = JSON.stringify(sessionStorage.getItem("userIdandOTP"));

    if (res != "") {
      let userId = parseInt(sessionStorage.getItem("userIdandOTP")!.split('.')[0]);
      let data: send_password;
      data = {
        userId: userId,
        newPassword: this.confirm_password
      }
      console.log(data);
      this.forgotPasswordService.updatePassword(data).subscribe(data => console.log(data), error => console.log(error));
      sessionStorage.removeItem("userIdandOTP");
      Swal.fire('Thank you...', 'Your password was changed succesfully!', 'success');
    }
  }
}
