import { Component, OnInit } from "@angular/core";
import { Http, Response, Headers, ResponseContentType } from "@angular/http";
import { Router, NavigationExtras } from "@angular/router";
import { FormBuilder, FormGroup } from "@angular/forms";

import "rxjs/add/operator/map";

declare var $: any;
declare var Materialize: any;

@Component({
  selector: "app-patient",
  templateUrl: "./patient.component.html",
  styleUrls: ["./patient.component.css"],
})
export class PatientComponent implements OnInit {
  managerMap: Map<number, any> = new Map<number, any>();
  departmentMap: Map<number, any> = new Map<number, any>();
  designationMap: Map<number, any> = new Map<number, any>();
  managerId: string;
  managers: any[] = [];
  managerList: any[] = [];
  departments: any[] = [];
  designations: any[] = [];
  record: any = null;
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
    this.loadIntialListOfpatients();
  }

  onNext(): void {
    this.page++;
    this.loadIntialListOfpatients();
  }

  onPrev(): void {
    this.page--;
    this.loadIntialListOfpatients();
  }

  constructor(_router: Router, private _http: Http) {
    this.router = _router;
    this.loadIntialListOfpatients();
  }

  private loadIntialListOfpatients() {
    this.isLoading = true;
    return this._http
      .get(`http://localhost:8181/healthhubapi/getWithUserId/${Number(localStorage.getItem('userId'))}`)
      .map((res: Response) => res.json())
      .subscribe(
        (data) => {
          this.record = data;
          // this.total = data.totalRecords;
          localStorage.setItem('fName',data.firstName);
          localStorage.setItem('lName',data.lastName);
          // console.log(data);
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
    this.router.navigate(["/patient/patientdetails"], navigationExtras);
  }

  public selectForDelete(id: string) {
    this.deleteId = id;
  }

  public delete(id: string) {
    var data = {
      "userId": id,
    };
    this.isLoading = true;
    return this._http
      .delete(`http://localhost:8181/healthhubapi/deleteByUserId/${this.deleteId}`)
      .subscribe(
        (data) => {
          var $toastContent = $(
            "<span>Record has been deleted successfully!!</span>"
          );
          Materialize.toast($toastContent, 2000);
          this.isLoading = false;
          this.loadIntialListOfpatients();
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
  }

  ngAfterViewChecked() {
    let self = this;
  }
}
