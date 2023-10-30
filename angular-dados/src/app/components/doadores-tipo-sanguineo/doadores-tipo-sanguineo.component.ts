import { Component } from '@angular/core';
import { DoadoresTipoSanguineo } from 'src/app/models/doadores-tipo-sanguineo';
import { DoadoresTipoSanguineoService } from 'src/app/services/doadores-tipo-sanguineo/doadores-tipo-sanguineo.service';

@Component({
  selector: 'app-doadores-tipo-sanguineo',
  templateUrl: './doadores-tipo-sanguineo.component.html',
  styleUrls: ['./doadores-tipo-sanguineo.component.css']
})
export class DoadoresTipoSanguineoComponent {

  doadoresTipoSanguineo: DoadoresTipoSanguineo[] = [];

  displayedColumns = [
    'tipo', 'doador'
];
 constructor( private doadoresTipoSanguineoService: DoadoresTipoSanguineoService ) { 
  
  }

   ngOnInit() {
    this.doadoresTipoSanguineoService.get().subscribe(
      data => {
        this.doadoresTipoSanguineo = data;
      }
    )
   }
}