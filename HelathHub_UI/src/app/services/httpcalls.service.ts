import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
@Injectable()
export class HttpcallsService {

   
  public resturl: string = ' ';
  constructor(private http: HttpClient) { }
 
  
}
