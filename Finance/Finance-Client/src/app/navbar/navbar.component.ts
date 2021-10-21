import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  isLoggedIn: string = 'TRUE';
  loginUser: string = JSON.stringify(sessionStorage.getItem("loginDone"));
  removeLogin: boolean = true;

  constructor() { }

  ngOnInit(): void {
    if(this.loginUser==='true'){
      this.removeLogin = false;
    }
  }

  handle_event =($event:string)=>{
    this.isLoggedIn=$event;

  }


}
