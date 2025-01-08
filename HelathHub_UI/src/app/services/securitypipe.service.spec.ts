import { TestBed, inject } from '@angular/core/testing';

import { SecuritypipeService } from './securitypipe.service';

describe('SecuritypipeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SecuritypipeService]
    });
  });

  it('should be created', inject([SecuritypipeService], (service: SecuritypipeService) => {
    expect(service).toBeTruthy();
  }));
});
