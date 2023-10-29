import { TestBed } from '@angular/core/testing';

import { CandidatosPorEstadoService } from './candidatos-por-estado.service';

describe('CandidatosPorEstadoService', () => {
  let service: CandidatosPorEstadoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CandidatosPorEstadoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
