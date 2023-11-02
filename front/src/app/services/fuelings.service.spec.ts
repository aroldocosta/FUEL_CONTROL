import { TestBed } from '@angular/core/testing';

import { FuelingsService } from './fuelings.service';

describe('FuelingsService', () => {
  let service: FuelingsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FuelingsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
