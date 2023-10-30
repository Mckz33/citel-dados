import { Pessoa } from './../../models/pessoa';
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
  public pessoas: Array<Pessoa> = [];
  public resposta!: CandidatosPorEstado;


  displayedColumns = [
    'Estado', 'Quantidade'
];
 constructor( private candidatosPorEstadoService: CandidatosPorEstadoService ) { }

   ngOnInit() {
    
    // this.candidatosPorEstadoService.get().subscribe(
    //   data => {
    //     this.candidatosPorEstado = data;
    //     console.log(data)
    //   }
    // );
   }


   onFileSelected(event: any) {
    console.log("Evento de seleção de arquivo acionado");
    const file: File = event.target.files[0];
  
    if (file) {
      const reader = new FileReader();
      reader.readAsText(file, "UTF-8");
      reader.onload = (evt: any) => {
        const fileContents = evt.target.result;
        try {
          const jsonData = JSON.parse(fileContents);
          console.log(jsonData);
          
          this.pessoas = jsonData;
          this.candidatosPorEstadoService.postData(this.pessoas).subscribe(
            (res: any) => {
              this.resposta = res;
              console.log(this.resposta);
            }
          )
         
        } catch (e) {
          console.error('Erro ao parsear o arquivo JSON', e);
        }
      };
      reader.onerror = (evt) => {
        console.error('Erro ao ler arquivo', evt);
      };
    }
  }
  
}
