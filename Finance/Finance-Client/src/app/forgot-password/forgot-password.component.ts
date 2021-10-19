import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
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
  otp: number = 0;
  wrongOTP: boolean = false;


  constructor(private _formBuilder: FormBuilder, private router: Router, private forgotPasswordService: ForgotPasswordService) { }

  ngOnInit(): void {
  }
  sendOTPActionButton() {
    this.forgotPasswordService.sendOTPActionButton(this.email).subscribe(data =>
      sessionStorage.setItem("userIdandOTP",JSON.stringify(data)), error => console.log(error));
      // data is stored in decimal value as "userId.otp"
  }

  verifyOTP() {
//     //take the value of otp from session storage(truncate the value after decimal for otp)
//     //compare the value from input and value from session storage
//     //if otp is correct go forward or invalid otp message
  // idAndOtp = sessionStorage.getItem("userIdandOTP");

  let res = JSON.stringify(sessionStorage.getItem("userIdandOTP"));

  if(res!=""){
    let userId = parseInt(sessionStorage.getItem("userIdandOTP")!.split('.')[0]);
    let otpId = parseInt(sessionStorage.getItem("userIdandOTP")!.split('.')[1]);
    console.log(userId);
    console.log(otpId);

    if(otpId===this.otp){}
    else{
      this.wrongOTP=true;
      confirm("please enter valid OTP");
    }
  

  }



  }

  updatePassword() {
//     //get the userid from session storage (truncate the integer before decimal)
//     let updateData: send_password = {
//       userID: JSON.parse(sessionStorage.getItem('userIdandOTP')),
//       new_password: this.new_password
//     }
//     this.forgotPasswordService.updatePassword(this.updateData).subscribe(data => console.log(data), error => console.log(error));

let res = JSON.stringify(sessionStorage.getItem("userIdandOTP"));

if(res!=""){
  let userId = parseInt(sessionStorage.getItem("userIdandOTP")!.split('.')[0]);
  // let otpId = parseInt(sessionStorage.getItem("userIdandOTP")!.split('.')[1]);

  let data:send_password;
  data={
    userId:userId,
    newPassword:this.confirm_password
  }
  console.log(data);
  this.forgotPasswordService.updatePassword(data).subscribe(data => console.log(data), error => console.log(error));




  // if(otpId===this.otp){}
  // else{
  //   this.wrongOTP=true;
  //   confirm("please enter valid OTP");
  // }


}
  }
}
