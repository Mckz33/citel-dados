import { BehaviorSubject, Observable, startWith, tap } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { CandidatosPorEstado } from 'src/app/models/candidatos-por-estado';
import { CandidatosPorEstadoService } from 'src/app/services/candidatos-por-estados/candidatos-por-estado.service';

@Component({
  selector: 'app-candidato-por-estado',
  templateUrl: './candidato-por-estado.component.html',
  styleUrls: ['./candidato-por-estado.component.css']
})
export class CandidatoPorEstadoComponent implements OnInit {
  
  private _candidatosPorEstado = new BehaviorSubject<CandidatosPorEstado[]>([]);
  public candidatosPorEstado$ = this._candidatosPorEstado.asObservable();

  displayedColumns = [
    'id', 'RR', 'RS', 'PR', 'DF', 'SC', 'SE', 'MA', 'MG', 'SP', 'AC', 'CE',
    'MS', 'MT', 'GO', 'AL', 'AM', 'ES', 'AP', 'PA', 'PB', 'PE', 'RJ', 'PI',
    'TO', 'RN', 'RO', 'BA'
];
 constructor( private candidatosPorEstadoService: CandidatosPorEstadoService ) {  }

   ngOnInit() {
    this.candidatosPorEstadoService.get().subscribe(data => {
      this._candidatosPorEstado.next(data);
    });
   }
}
