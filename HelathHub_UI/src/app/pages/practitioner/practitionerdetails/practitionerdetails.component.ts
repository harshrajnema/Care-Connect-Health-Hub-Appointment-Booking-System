import { Component, OnInit, AfterViewChecked, ViewChildren, AfterViewInit  } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { NgModel, FormControl } from '@angular/forms';
import 'rxjs/add/operator/map';

declare var $: any;
declare var Materialize: any;

@Component({
  selector: 'app-practitionerdetails',
  templateUrl: './practitionerdetails.component.html',
  styleUrls: ['./practitionerdetails.component.css']
})
export class PractitionerdetailsComponent implements  OnInit, AfterViewChecked {

 isLoading: boolean = false;
 
      
      isApproved: string;
      isActive: string;
     doctorId: string;
     firstName: string;
     middleName: string;
     lastName: string;
     specialty: string;  
     emailId: string;
     phoneNumber: string;
     roleId: string;
      editId: string;


  router: Router;
   RAGAMusicProfileCode : string;
  @ViewChildren('allTheseThings') things;

    constructor(_router: Router, private _http: Http, private route: ActivatedRoute) {
    this.router = _router;
     
  }

    
 
  private createNewPractitioner() {
    this.isLoading = true;
    var data22 = {       
      "firstName": this.firstName,
      "lastName": this.lastName,
      "specialty": this.specialty,  
      "emailId": this.emailId,  
      "phoneNumber": this.phoneNumber    
  };
 

    if (this.editId  && this.editId !== ""  && this.editId !== "None") {
     

      data22["doctorId"] = this.editId;
      return this._http.put('http://localhost:8181/healthhubapi/updatePractitioner', data22)
        .subscribe(
        res => {
          console.log(res);
          this.isLoading = false;
          var $toastContent = $('<span>Record has been saved successfully!!</span>');
          Materialize.toast($toastContent, 2000);
          this.router.navigate(['/practitioner']);
        },
        err => {
          var $toastContent = $('<span>'+JSON.parse(err["_body"])[0]["errMessage"]+'</span>');
          Materialize.toast($toastContent, 2000);                      
          this.isLoading = false;
        }
        );
    }  else{
      console.log(data22);
            return this._http.post('http://localhost:8181/healthhubapi/createPractitioner', data22)
        .subscribe(
        res => {
          console.log(res);
          this.isLoading = false;
          var $toastContent = $('<span>Record has been saved successfully!!</span>');
          Materialize.toast($toastContent, 2000);
          this.router.navigate(['/practitioner']);
        },
        err => {
          var $toastContent = $('<span>'+JSON.parse(err["_body"])[0]["errMessage"]+'</span>');
          Materialize.toast($toastContent, 2000);            
          this.isLoading = false;
        }
        );
    }
  }
  

  public moveNext(event, tab) {
    $('.collapsible').collapsible('open', tab);
  }
ngAfterViewInit() {
    this.things.changes.subscribe(t => {
      $("select").material_select();
    });
     $('#dob').pickadate({
    selectMonths: true,
    selectYears: 100, 
    closeOnSelect: true
  });

  }

  ngAfterViewChecked() {
   
    Materialize.updateTextFields();

  }
  ngOnInit() {
    $("select").material_select();
    $('.collapsible').collapsible({      
      onOpen: function(el) {  Materialize.updateTextFields(); }
    });

    this.route
      .queryParamMap
      .map(params => params.get('session_id') || 'None')
      .subscribe(val => this.editId = val);
    console.log('Hello ---------------------->');
    console.log(this.editId);

    if (this.editId  && this.editId !== ""  && this.editId !== "None") {
      this.isLoading = true;
      return this._http.get(`http://localhost:8181/healthhubapi/getPractitionerById/${ this.editId}`)
        .map((res: Response) => res.json())
        .subscribe(data => {
          var practitionerList = data;
          console.log(data);
          
          this.editId = practitionerList.doctorId; 
          this.firstName = practitionerList.firstName;
          
          this.lastName = practitionerList.lastName;
          this.specialty = practitionerList.specialty;
         
          this.emailId = practitionerList.emailId;
           
          this.phoneNumber = practitionerList.phoneNumber;
         
           
          
         this.isLoading = false;
          
        

          $("select").material_select();

      

          Materialize.updateTextFields();
          //debugger;
        },
          err => {
            console.log('Something went wrong!');
            this.isLoading = false;
          });
    }
    //   let m = this.model;
    //   m.valueChanges.subscribe(value => {
    //     Materialize.updateTextFields();
    // });
    Materialize.updateTextFields();
  }
 
  }








