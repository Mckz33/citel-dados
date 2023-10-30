import { TestBed } from '@angular/core/testing';

import { MediaIdadeSanguineoService } from './media-idade-sanguineo.service';

describe('MediaIdadeSanguineoService', () => {
  let service: MediaIdadeSanguineoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MediaIdadeSanguineoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
