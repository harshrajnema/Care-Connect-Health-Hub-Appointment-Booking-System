import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StatusdetailsComponent } from './statusdetails.component';

describe('StatusdetailsComponent', () => {
  let component: StatusdetailsComponent;
  let fixture: ComponentFixture<StatusdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StatusdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StatusdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
