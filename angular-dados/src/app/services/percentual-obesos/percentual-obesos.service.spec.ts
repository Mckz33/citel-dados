import { TestBed } from '@angular/core/testing';

import { PercentualObesosService } from './percentual-obesos.service';

describe('PercentualObesosService', () => {
  let service: PercentualObesosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PercentualObesosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
