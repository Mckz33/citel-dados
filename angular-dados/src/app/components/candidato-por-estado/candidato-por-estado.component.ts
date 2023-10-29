import { Observable } from 'rxjs';
import { CandidatosPorEstado } from 'src/app/models/candidatos-por-estado';

import { Component, OnInit } from '@angular/core';
import { CandidatosPorEstadoService } from 'src/app/services/candidatos-por-estados/candidatos-por-estado.service';

@Component({
  selector: 'app-candidato-por-estado',
  templateUrl: './candidato-por-estado.component.html',
  styleUrls: ['./candidato-por-estado.component.css']
})
export class CandidatoPorEstadoComponent implements OnInit {
  
  // candidatosPorEstado!: Observable<CandidatosPorEstado[]>

  // candidatosPorEstado!: Observable<CandidatosPorEstado[]>;

  candidatosPorEstado: CandidatosPorEstado[] = [];

  displayedColumns = [
    'Estado', 'Quantidade'
];
 constructor( private candidatosPorEstadoService: CandidatosPorEstadoService ) { 
  
  }

   ngOnInit() {
    this.candidatosPorEstadoService.get().subscribe(
      data => {
        this.candidatosPorEstado = data;
      }
    )
    // this.candidatosPorEstadoService.get().subscribe(
    //   data => {
    //     this.candidatosPorEstado = data;
    //     console.log(data)
    //   }
    // );
   }
}
