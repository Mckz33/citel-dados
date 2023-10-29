import { TestBed } from '@angular/core/testing';

import { ImcMedioPorFaixaEtariaService } from './imc-medio-por-faixa-etaria.service';

describe('ImcMedioPorFaixaEtariaService', () => {
  let service: ImcMedioPorFaixaEtariaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImcMedioPorFaixaEtariaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
