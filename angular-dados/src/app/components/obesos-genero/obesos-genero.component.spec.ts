import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObesosGeneroComponent } from './obesos-genero.component';

describe('ObesosGeneroComponent', () => {
  let component: ObesosGeneroComponent;
  let fixture: ComponentFixture<ObesosGeneroComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ObesosGeneroComponent]
    });
    fixture = TestBed.createComponent(ObesosGeneroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
