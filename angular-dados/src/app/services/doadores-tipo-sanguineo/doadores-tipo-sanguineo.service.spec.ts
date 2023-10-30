import { TestBed } from '@angular/core/testing';

import { DoadoresTipoSanguineoService } from './doadores-tipo-sanguineo.service';

describe('DoadoresTipoSanguineoService', () => {
  let service: DoadoresTipoSanguineoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DoadoresTipoSanguineoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
