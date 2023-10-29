import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarCandidatosBrasilComponent } from './listar-candidatos-brasil.component';

describe('ListarCandidatosBrasilComponent', () => {
  let component: ListarCandidatosBrasilComponent;
  let fixture: ComponentFixture<ListarCandidatosBrasilComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListarCandidatosBrasilComponent]
    });
    fixture = TestBed.createComponent(ListarCandidatosBrasilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
