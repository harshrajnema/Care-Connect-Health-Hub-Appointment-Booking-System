import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import { Http, Response, Headers } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { NgModel, FormControl } from '@angular/forms';
import 'rxjs/add/operator/map';

declare var $: any;
declare var Materialize: any;

@Injectable()
export class AuthService {

  private event = new BehaviorSubject<number>(0);
  loginEvent$ = this.event.asObservable();

  constructor(private http: HttpClient){}

  
login(username: string, password: string) {
  const url = `http://localhost:8181/healthhubapi/getAuthentication/${encodeURIComponent(username)}/${encodeURIComponent(password)}`;
  //const userID;
  //         if (username === "johndoe" && password === "admin" || username === "nightmare" && password === "user") {
  //      localStorage.setItem('currentUser', 'User');
  //      localStorage.setItem('role', "0");
  //      this.event.next(1);
  //      return true;
  //     }
  //     else{
  //       var $toastContent = $('<span class=""><i class="material-icons left red-text">error</i>Invalid Username / Password</span>');
  //       Materialize.toast($toastContent, 3000); 
  //     }
  //    return false;
  // }
   this.http.get(url).subscribe(
      (userId) => {
      if (userId) {
        // Save user data in localStorage for further use
        localStorage.setItem('currentUser', username);
        localStorage.setItem('userId', userId.toString());
        console.log(Number(localStorage.getItem('userId')));
        console.log(typeof(Number(localStorage.getItem('userId'))));         
        localStorage.setItem('role', '0'); // Assign a default role for simplicity
        this.event.next(1); // Trigger an event (assuming event is a Subject or EventEmitter)
        return true;
      } else {
        var $toastContent = $('<span class=""><i class="material-icons left red-text">error</i>Invalid Username / Password</span>');
        Materialize.toast($toastContent, 3000);
        // return false;
      }
      return false;
    },
    (error) => {
      if (error.status === 500) {
          // Display "Invalid Username/Password" message
          const $toastContent = $('<span class=""><i class="material-icons left red-text">error</i>Invalid Username / Password</span>');
          Materialize.toast($toastContent, 3000);
      } else {
          // this.showToast('Error during login. Please try again.');
          console.error(error);
      }
      return false;
    }
    );
  
    // (error) => {
    //   this.showToast('Error during login. Please try again.');
    //   console.error(error);
    //   return false;
    // }
 
}

 

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.event.next(0);
  }

  isAuthenicated() {
    let currentUser = localStorage.getItem('currentUser');
    if(currentUser && currentUser !== "") {
      return true;
    }
    return false;
  }

}
 