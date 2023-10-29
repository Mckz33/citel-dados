import { TestBed } from '@angular/core/testing';

import { PossiveisDoadoresService } from './possiveis-doadores.service';

describe('PossiveisDoadoresService', () => {
  let service: PossiveisDoadoresService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PossiveisDoadoresService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
