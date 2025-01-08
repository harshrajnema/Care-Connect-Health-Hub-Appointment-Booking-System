import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { NgModel, FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

declare var $: any;
declare var Materialize: any;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  email: string;
  isLogin: boolean = true;
  isLoading: boolean = false;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.authService.loginEvent$.subscribe(id => this.isLoading = false);
  }

  loginmain() {
    this.isLoading = true;
    this.authService.login(this.username, this.password);


  }
  navigateToSignup() {
    this.router.navigate(['/signup']);
   // Navigates to the signup page
   this.isLogin=false;
   console.log("Clicked");
  }
  forgotPasswordClick() {
    this.isLogin = false;
  }
 
  cancel() {
    this.isLogin = true; 
  }

}
