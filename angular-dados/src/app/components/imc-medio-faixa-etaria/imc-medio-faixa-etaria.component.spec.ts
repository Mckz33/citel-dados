import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImcMedioFaixaEtariaComponent } from './imc-medio-faixa-etaria.component';

describe('ImcMedioFaixaEtariaComponent', () => {
  let component: ImcMedioFaixaEtariaComponent;
  let fixture: ComponentFixture<ImcMedioFaixaEtariaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ImcMedioFaixaEtariaComponent]
    });
    fixture = TestBed.createComponent(ImcMedioFaixaEtariaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
