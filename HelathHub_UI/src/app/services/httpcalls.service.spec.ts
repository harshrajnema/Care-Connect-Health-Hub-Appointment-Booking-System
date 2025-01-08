import { TestBed, inject } from '@angular/core/testing';

import { HttpcallsService } from './httpcalls.service';

describe('HttpcallsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HttpcallsService]
    });
  });

  it('should be created', inject([HttpcallsService], (service: HttpcallsService) => {
    expect(service).toBeTruthy();
  }));
});
