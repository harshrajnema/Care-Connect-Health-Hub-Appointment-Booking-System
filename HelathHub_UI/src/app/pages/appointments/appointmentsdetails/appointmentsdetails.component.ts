import {
  Component,
  OnInit,
  AfterViewChecked,
  ViewChildren,
  AfterViewInit,
} from "@angular/core";
import { Http, Response, Headers } from "@angular/http";
import { HttpClient } from "@angular/common/http";
import { Router, ActivatedRoute } from "@angular/router";
import { Observable } from "rxjs/Observable";
import { NgModel, FormControl } from "@angular/forms";
import "rxjs/add/operator/map";

declare var $: any;
declare var Materialize: any;

@Component({
  selector: "app-appointmentsdetails",
  templateUrl: "./appointmentsdetails.component.html",
  styleUrls: ["./appointmentsdetails.component.css"],
})
export class AppointmentsdetailsComponent implements OnInit, AfterViewChecked {
  isLoading: boolean = false;

  isApproved: string;
  isActive: string;
  doctorId: string;
  patientId: string | null = null;
  firstName: string;
  appointmentDate: string;
  appointmentId: string;
  middleName: string;
  lastName: string;

  email: string;
  phoneNumber: string;
  roleId: string;
  editId: string;
  appointmentTime: string;
  status: string;
  reasonForVisit: string;

  router: Router;
  RAGAMusicProfileCode: string;
  
  @ViewChildren("allTheseThings") things;

  constructor(
    _router: Router,
    private _http: Http,
    private route: ActivatedRoute
  ) {
    this.router = _router;
  }

  private createNewAppointment() {
    this.isLoading = true;
    var data22 = {
      "patientId": this.patientId,
      "doctorId": this.doctorId,

      "appointmentDate": this.appointmentDate,
      "appointmentTime": this.appointmentTime,
      "status": this.status,
      "reasonForVisit": this.reasonForVisit
    };

    if (this.editId && this.editId !== "" && this.editId !== "None") {
      data22["appointmentId"] = this.editId;
      return this._http
        .put("http://localhost:8181/healthhubapi/updateAppointment", data22)
        .subscribe(
          (res) => {
            console.log(res);
            this.isLoading = false;
            var $toastContent = $(
              "<span>Record has been saved successfully!!</span>"
            );
            Materialize.toast($toastContent, 2000);
            this.router.navigate(["/appointments"]);
          },
          (err) => {
            var $toastContent = $(
              "<span>" + JSON.parse(err["_body"])[0]["errMessage"] + "</span>"
            );
            Materialize.toast($toastContent, 2000);
            this.isLoading = false;
          }
        );
    } else {
      console.log(data22);
      return this._http
        .post("http://localhost:8181/healthhubapi/makeAppointment", data22)
        .subscribe(
          (res) => {
            console.log(res);
            this.isLoading = false;
            var data1={
              "status": "pending",
              "reason": "Keep patience you will be notified"
            };
            this._http
        .post("http://localhost:8181/healthhubapi/makeStatus", data1)
        .subscribe((result)=>
          console.log(result));
            var $toastContent = $(
              "<span>Record has been saved successfully!!</span>"
            );
            Materialize.toast($toastContent, 2000);
            this.router.navigate(["/appointments"]);
          },
          (err) => {
            var $toastContent = $(
              "<span>" + JSON.parse(err["_body"])[0]["errMessage"] + "</span>"
            );
            Materialize.toast($toastContent, 2000);
            this.isLoading = false;
          }
        );
    }
  }

  public moveNext(event, tab) {
    $(".collapsible").collapsible("open", tab);
  }
  ngAfterViewInit() {
    this.things.changes.subscribe((t) => {
      $("select").material_select();
    });
    $("#dob").pickadate({
      selectMonths: true,
      selectYears: 100,
      closeOnSelect: true,
    });
  }

  ngAfterViewChecked() {
    Materialize.updateTextFields();
  }
  ngOnInit() {
    $("select").material_select();
    this.patientId = localStorage.getItem('userId');
    $(".collapsible").collapsible({
      onOpen: function (el) {
        Materialize.updateTextFields();
      },
    });

    this.route.queryParamMap
      .map((params) => params.get("session_id") || "None")
      .subscribe((val) => (this.editId = val));
    console.log("Hello ---------------------->");
    console.log(this.editId);

    if (this.editId && this.editId !== "" && this.editId !== "None") {
      this.isLoading = true;
      return this._http
        .get(`http://localhost:8181/healthhubapi/getAppointmentWithId/${this.editId}`)
        .map((res: Response) => res.json())
        .subscribe(
          (data) => {
            var AppointmentsList = data;
            // console.log(data);
            this.appointmentId=AppointmentsList.appointmentId;
            this.patientId=AppointmentsList.patientId;
            this.doctorId = AppointmentsList.doctorId;
            // this.firstName = AppointmentsList.firstName;

            // this.lastName = AppointmentsList.lastName;

            this.appointmentDate = AppointmentsList.appointmentDate;

            this.appointmentTime = AppointmentsList.appointmentTime;

            this.status = AppointmentsList.status;

            this.reasonForVisit = AppointmentsList.reasonForVisit;


            this.isLoading = false;

            $("select").material_select();

            Materialize.updateTextFields();
            //debugger;
          },
          (err) => {
            console.log("Something went wrong!");
            this.isLoading = false;
          }
        );
    }
    //   let m = this.model;
    //   m.valueChanges.subscribe(value => {
    //     Materialize.updateTextFields();
    // });
    Materialize.updateTextFields();
  }
}
