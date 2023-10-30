import { Component } from '@angular/core';
import { ObesosGenero } from 'src/app/models/obesos-genero';
import { ObesosGeneroService } from 'src/app/services/obesos-genero/obesos-genero.service';

@Component({
  selector: 'app-obesos-genero',
  templateUrl: './obesos-genero.component.html',
  styleUrls: ['./obesos-genero.component.css']
})
export class ObesosGeneroComponent {

  obesosGenero: ObesosGenero[] = [];

  displayedColumns = [
    'percentualObesosHomens', 'percentualObesosMulheres'
];
 constructor( private obesosGeneroService: ObesosGeneroService ) { 
  
  }

   ngOnInit() {
    this.obesosGeneroService.get().subscribe(
      data => {
        this.obesosGenero = data;
      }
    )
   }
}
