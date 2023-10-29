import { TestBed } from '@angular/core/testing';

import { MediaPorTipoSanguineoService } from './media-por-tipo-sanguineo.service';

describe('MediaPorTipoSanguineoService', () => {
  let service: MediaPorTipoSanguineoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MediaPorTipoSanguineoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
