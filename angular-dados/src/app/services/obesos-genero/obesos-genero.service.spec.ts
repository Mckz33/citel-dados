import { TestBed } from '@angular/core/testing';

import { ObesosGeneroService } from './obesos-genero.service';

describe('ObesosGeneroService', () => {
  let service: ObesosGeneroService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ObesosGeneroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
