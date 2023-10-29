import { ImcMedioPorFaixaEtariaService } from './../../services/imc-medio-por-faixa-etaria/imc-medio-por-faixa-etaria.service';
import { ImcFaixaEtaria } from './../../models/imc-faixa-etaria';
import { Component } from '@angular/core';

@Component({
  selector: 'app-imc-medio-faixa-etaria',
  templateUrl: './imc-medio-faixa-etaria.component.html',
  styleUrls: ['./imc-medio-faixa-etaria.component.css']
})
export class ImcMedioFaixaEtariaComponent {

  imcFaixaEtaria: ImcFaixaEtaria[] = [];

  displayedColumns = [
    'Estado', 'Quantidade'
];
 constructor( private imcMedioPorFaixaEtariaService: ImcMedioPorFaixaEtariaService ) { 
  
  }

   ngOnInit() {
    this.imcMedioPorFaixaEtariaService.get().subscribe(
      data => {
        this.imcFaixaEtaria = data;
      }
    )
   }
}

