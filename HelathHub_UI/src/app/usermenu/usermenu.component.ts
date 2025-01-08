import { Component, OnInit } from '@angular/core';

declare var $: any;

@Component({
  selector: 'app-usermenu',
  templateUrl: './usermenu.component.html',
  styleUrls: ['./usermenu.component.css']
})
export class UserMenuComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $(".button-collapse").sideNav({
      menuWidth: 250, 
      closeOnClick: true, 
      draggable: true
    });
  }

}
