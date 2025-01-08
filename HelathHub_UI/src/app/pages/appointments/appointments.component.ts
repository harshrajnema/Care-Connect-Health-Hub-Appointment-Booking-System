import { Component, OnInit } from "@angular/core";
import { Http, Response, Headers, ResponseContentType } from "@angular/http";
import { Router, NavigationExtras } from "@angular/router";
import { FormBuilder, FormGroup } from "@angular/forms";

import "rxjs/add/operator/map";

declare var $: any;
declare var Materialize: any;

@Component({
  selector: "app-appointments",
  templateUrl: "./appointments.component.html",
  styleUrls: ["./appointments.component.css"],
})
export class AppointmentsComponent implements OnInit {
  doctormap: Map<number, any> = new Map<number, any>();
  patientmap: Map<number, any> = new Map<number, any>();
  designationMap: Map<number, any> = new Map<number, any>();
  managerId: string;
  managers: any[] = [];
  managerList: any[] = [];
  doctors: any[] = [];
  patients: any[] = [];
  records: any[] = [];
  ids: any[]=[];
  isLoading: boolean = false;
  router: Router;
  deleteId: string;
  totalEmployees: string;
  uploadForm: FormGroup;

  total = 0;
  page = 1;
  limit = 10;
  goToPage(n: number): void {
    this.page = n;
    this.loadIntialListOfAppointmentss();
  }

  onNext(): void {
    this.page++;
    this.loadIntialListOfAppointmentss();
  }

  onPrev(): void {
    this.page--;
    this.loadIntialListOfAppointmentss();
  }

  constructor(_router: Router, private _http: Http) {
    this.router = _router;
    this.updateDoctorName();
    this.updatePatientName();

    this.loadIntialListOfAppointmentss();
  }

  private updatePatientName() {
    this._http
      .get("http://localhost:8181/healthhubapi/listAllUsers")
      .map((res: Response) => res.json())
      .subscribe((data) => {
        this.patients = data;
        for (let patient of this.patients) {
          this.patientmap.set(
            patient.patientId,
            patient.firstName + patient.lastName
          );
        }

        console.log(this.patients);
      });
  }
  private updateDoctorName() {
    this._http
      .get("http://localhost:8181/healthhubapi/listAllPractitioners")
      .map((res: Response) => res.json())
      .subscribe((data) => {
        this.doctors = data;

        for (let doctor of this.doctors) {
          this.doctormap.set(
            doctor.doctorId,
            doctor.firstName + doctor.lastName
          );
        }
      });
  }

  private loadIntialListOfAppointmentss() {
    this.isLoading = true;
    return this._http
      .get(`http://localhost:8181/healthhubapi/getAppointmentByPatientId/${Number(localStorage.getItem('userId'))}`)
      .map((res: Response) => res.json())
      .subscribe(
        (data) => {
          this.records = data.content;
          this.total = data.totalRecords;
          console.log(this.records);
          for (let i = 0; i < this.records.length; i++) {
            this.ids.push(this.records[i].appointmentId);
          }
        //  console.log(this.ids);
        // Convert the array to a string and store it
        localStorage.setItem("idArray",this.ids.join(','));
        // console.log(localStorage.getItem('idArray'));
          this.isLoading = false;
        },
        (err) => {
          console.log("Something went wrong!");
          this.isLoading = false;
        }
      );
  }

  public edit(id: string) {
    let navigationExtras: NavigationExtras = {
      queryParams: { session_id: id },
      skipLocationChange: true,
    };
    this.router.navigate(
      ["/appointments/appointmentsdetails"],
      navigationExtras
    );
  }

  public selectForDelete(id: string) {
    this.deleteId = id;
  }

  public delete(id: string) {
    var data = {
      "appointmentId": id
    };
    this.isLoading = true;
    return this._http
      .delete(
        `http://localhost:8181/healthhubapi/deleteByAppointmentId/${this.deleteId}`)
      .subscribe(
        (data) => {
          var $toastContent = $(
            "<span>Record has been deleted successfully!!</span>"
          );
          Materialize.toast($toastContent, 2000);
          this.isLoading = false;
          this.loadIntialListOfAppointmentss();
        },
        (err) => {
          console.log("Something went wrong!");
          this.isLoading = false;
        }
      );
  }

  public moveNext(event, tab) {
    $(".collapsible").collapsible("open", tab);
  }

  ngOnInit() {
    $("select").material_select();
    $(".collapsible").collapsible();
    $(".modal").modal();
    this.updateDoctorName();
  }

  ngAfterViewChecked() {
    let self = this;
  }
}
