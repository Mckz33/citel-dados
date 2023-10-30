import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MediaIdadeSanguineoComponent } from './media-idade-sanguineo.component';

describe('MediaIdadeSanguineoComponent', () => {
  let component: MediaIdadeSanguineoComponent;
  let fixture: ComponentFixture<MediaIdadeSanguineoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MediaIdadeSanguineoComponent]
    });
    fixture = TestBed.createComponent(MediaIdadeSanguineoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
