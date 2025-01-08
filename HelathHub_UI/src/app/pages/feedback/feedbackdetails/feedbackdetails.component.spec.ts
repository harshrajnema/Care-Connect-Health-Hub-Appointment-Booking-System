import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedbackdetailsComponent } from './feedbackdetails.component';

describe('FeedbackdetailsComponent', () => {
  let component: FeedbackdetailsComponent;
  let fixture: ComponentFixture<FeedbackdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeedbackdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeedbackdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
