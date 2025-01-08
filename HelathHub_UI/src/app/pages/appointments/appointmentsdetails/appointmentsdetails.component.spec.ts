import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentsdetailsComponent } from './appointmentsdetails.component';

describe('AppointmentsdetailsComponent', () => {
  let component: AppointmentsdetailsComponent;
  let fixture: ComponentFixture<AppointmentsdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppointmentsdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppointmentsdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
