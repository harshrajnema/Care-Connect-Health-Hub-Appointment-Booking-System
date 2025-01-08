import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MaterializeModule } from 'angular2-materialize';
import { ChartsModule } from 'ng2-charts';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MenuComponent } from './menu/menu.component';
  import { AppRoutingModule } from './/app-routing.module';
 import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
 import { SafePipe } from './safe.pipe';

// import { PatientLoginComponent } from './loginpatient/patientlogin.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AuthService } from './services/auth.service';

   import { Pipe, PipeTransform } from '@angular/core';
import { Directive } from '@angular/core';

import { Component } from '@angular/core';
import { CKEditorModule } from 'ng2-ckeditor';
 
 
  
  import { PaginationComponent } from './pagination/pagination.component';
  import { PatientComponent} from './pages/patient/patient.component';
  import { PatientdetailsComponent } from './pages/patient/patientdetails/patientdetails.component';
   

import { PractitionerComponent } from './pages/practitioner/practitioner.component';
import { PractitionerdetailsComponent } from './pages/practitioner/practitionerdetails/practitionerdetails.component';
 
import { AppointmentsComponent} from './pages/appointments/appointments.component';
import {  AppointmentsdetailsComponent } from './pages/appointments/appointmentsdetails/appointmentsdetails.component'; 


import { StatusComponent} from './pages/status/status.component';
import {  StatusdetailsComponent } from './pages/status/statusdetails/statusdetails.component';

import { FeedbackComponent } from './pages/feedback/feedback.component';
import { FeedbackdetailsComponent } from './pages/feedback/feedbackdetails/feedbackdetails.component';

import {ScheduleModule} from 'primeng/schedule';
  
import { HttpClientModule } from '@angular/common/http';
import { HttpcallsService } from './services/httpcalls.service';
import { SecuritypipeService } from './services/securitypipe.service';


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {DialogModule} from 'primeng/dialog';
import {DropdownModule} from 'primeng/dropdown';
import {TableModule} from 'primeng/table';
import {GrowlModule} from 'primeng/growl';
import { MessageService } from 'primeng/components/common/messageservice';

import {CalendarModule} from 'primeng/calendar';
//import {DropdownModule} from 'primeng/dropdown';
//import { FormsModule, ReactiveFormsModule } from '@angular/forms';
//import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
//import { HttpClientModule } from '@angular/common/http';
//import {EventService} from './pages/schedulecmp/EventService'
//import { FullCalendar }      from 'fullcalendar/fullcalendar';
import {ChartModule,   SharedModule} from 'primeng/primeng';
import {FileUploadModule} from 'primeng/primeng';
 import {InputSwitchModule} from 'primeng/inputswitch';  
// import { UploadComponent } from './pages/upload/upload.component';
 //import { CygnusreportsComponent } from './pages/cygnusreports/cygnusreports.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    MenuComponent,
     LoginComponent,
     SignupComponent,
    //  PatientLoginComponent,
    PaginationComponent,
  
    PractitionerComponent,
    PractitionerdetailsComponent,
    PatientComponent,
    PatientdetailsComponent,
    AppointmentsComponent,
    AppointmentsdetailsComponent,
    StatusComponent,
    StatusdetailsComponent,
    FeedbackComponent,
    FeedbackdetailsComponent,
    
    SafePipe

  ],
  imports: [
    BrowserModule,
    MaterializeModule,
    AppRoutingModule,
    FormsModule,
    HttpModule,
    ChartsModule,
    TableModule,DialogModule,
    DropdownModule,
    GrowlModule,
    BrowserAnimationsModule,
    ScheduleModule,
    HttpClientModule,
    CalendarModule,
    SharedModule,
    ChartModule,   
    InputSwitchModule,
    FileUploadModule,
    CKEditorModule

     
  ],
  providers: [
    AuthService,HttpcallsService,MessageService,SecuritypipeService
  ],
   bootstrap: [AppComponent]
})
export class AppModule { }
