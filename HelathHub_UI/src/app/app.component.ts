  import { Component, OnInit , HostListener , OnDestroy } from '@angular/core';
import { AuthService } from './services/auth.service'; 
import {Subscription} from 'rxjs/Subscription';

declare var $: any;
declare var Materialize: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

@Component({
  selector: 'app-custodian',
  templateUrl: './appcustodian.component.html',
  styleUrls: ['./appcustodian.component.css']
})

export class AppComponent implements  OnInit, OnDestroy  {

  userMenuShow: boolean = false;
  adminMenuShow: boolean =  false;


  isAuthenticated: boolean = false;

  constructor(private authService: AuthService) {}

  ngOnInit() {
    this.authService.loginEvent$.subscribe(id => this.updateAuthentication());
    this.isAuthenticated = this.authService.isAuthenicated();
    console.log ('Inside ngOnInit  app component  ');    
  }

  ngOnDestroy(): void {
  debugger;
        console.log ('Inside  ngOnDestroy app component  ');   
            localStorage.removeItem('currentUser');
            localStorage.removeItem('role');
    }


@HostListener('window:beforeunload', [ '$event' ])
  beforeUnloadHander(event) {
      localStorage.removeItem('currentUser');
    localStorage.removeItem('role');
    //debugger;
  }

  updateAuthentication() {
      console.log ('Inside updateAuthentication  app component  ');   
      var roleOfUser = localStorage.getItem('role');
        console.log('Printing Local Storage value '+localStorage.getItem('role'));
         
        this.userMenuShow = true;
        this.adminMenuShow = true;
         
       
       
        console.log ('this.userMenuShow   '+this.userMenuShow);
        console.log ('this.adminMenuShow  '+this.adminMenuShow);

 
    this.isAuthenticated = this.authService.isAuthenicated();
    if(this.isAuthenticated) {
      var $toastContent = $('<span class=""><i class="material-icons left green-text">mood</i>Welcome '+localStorage.getItem('currentUser')+'</span>');
      Materialize.toast($toastContent, 3000); 
    }
  }
}