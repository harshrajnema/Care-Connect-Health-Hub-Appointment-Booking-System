import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientdetailsComponent } from './patientdetails.component';

describe('PatientdetailsComponent', () => {
  let component: PatientdetailsComponent;
  let fixture: ComponentFixture<PatientdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
