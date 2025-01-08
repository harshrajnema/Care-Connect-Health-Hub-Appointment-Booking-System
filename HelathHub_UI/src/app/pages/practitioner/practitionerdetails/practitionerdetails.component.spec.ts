import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PractitionerdetailsComponent } from './practitionerdetails.component';

describe('PractitionerdetailsComponent', () => {
  let component: PractitionerdetailsComponent;
  let fixture: ComponentFixture<PractitionerdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PractitionerdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PractitionerdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
