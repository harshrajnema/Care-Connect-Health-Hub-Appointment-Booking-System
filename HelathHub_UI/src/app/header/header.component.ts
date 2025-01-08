import { Component, OnInit, AfterViewChecked, ViewChildren, AfterViewInit  } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute,NavigationExtras } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { NgModel, FormControl } from '@angular/forms';
import 'rxjs/add/operator/map';
import { AuthService } from '../services/auth.service';
import {Subscription} from 'rxjs/Subscription';
declare var $: any;


declare var $: any;
declare var Materialize: any; 

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, AfterViewChecked  {
  isAuthenticated: boolean = false;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.loginEvent$.subscribe(id => this.updateAuthentication());
    this.updateAuthentication();    
  }

  logout() {
    this.authService.logout();
  }

  updateAuthentication() {
    this.isAuthenticated = this.authService.isAuthenicated();
  }
    
  toggleSideNav() {
    if(this.isAuthenticated) {
      $("#slide-out").sideNav("show");
    }
    
  }

 ngAfterViewChecked() {      

  

      }
}
