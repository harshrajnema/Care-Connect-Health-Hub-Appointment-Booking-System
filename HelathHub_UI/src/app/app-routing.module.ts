import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
 
 
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
// import { PatientLoginComponent } from './loginpatient/patientlogin.component';

 

import { PractitionerComponent } from './pages/practitioner/practitioner.component';
import { PractitionerdetailsComponent } from './pages/practitioner/practitionerdetails/practitionerdetails.component';
import { PatientComponent} from './pages/patient/patient.component';
import { PatientdetailsComponent } from './pages/patient/patientdetails/patientdetails.component';
import { AppointmentsComponent} from './pages/appointments/appointments.component';
import {  AppointmentsdetailsComponent } from './pages/appointments/appointmentsdetails/appointmentsdetails.component'; 
import { StatusComponent } from './pages/status/status.component';
import { StatusdetailsComponent } from './pages/status/statusdetails/statusdetails.component';
import { FeedbackComponent } from './pages/feedback/feedback.component';
import { FeedbackdetailsComponent } from './pages/feedback/feedbackdetails/feedbackdetails.component';
 
const routes: Routes = [
  // { path: '', redirectTo: '/practitioner', pathMatch: 'full' },
  { path: '', redirectTo: '/patient', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  // { path: 'loginpatient', component: PatientLoginComponent },
    
       
  

  
  { path: 'practitioner', component: PractitionerComponent },
  { path: 'practitioner/practitionerdetails', component: PractitionerdetailsComponent },
  { path: 'patient', component: PatientComponent },
  { path: 'patient/patientdetails', component: PatientdetailsComponent },
  { path: 'appointments', component: AppointmentsComponent },
  { path: 'appointments/appointmentsdetails', component: AppointmentsdetailsComponent },
  { path: 'status', component: StatusComponent },
  { path: 'status/statusdetails', component: StatusdetailsComponent },
  { path: 'feedback', component: FeedbackComponent },
  { path: 'feedback/feedbackdetails', component: FeedbackdetailsComponent },
  
 
  ]; 

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes, { useHash: true })]
})
export class AppRoutingModule { } 