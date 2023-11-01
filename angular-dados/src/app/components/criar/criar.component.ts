import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { Pessoa } from 'src/app/models/pessoa';
import { CandidatosPorEstadoService } from 'src/app/services/candidatos-por-estados/candidatos-por-estado.service';

@Component({
  selector: 'app-criar',
  templateUrl: './criar.component.html',
  styleUrls: ['./criar.component.css']
})
export class CriarComponent implements OnInit {

  public pessoas: Array<Pessoa> = [];
  public tables: any[] = [];
  public totalElements: number = 0;
  public columns: string[] = [];
  public columnsToDisplay = ['nome', 'cpf', 'email', 'altura', 'sexo', 'peso'];

  public resposta: any;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private candidatosPorEstadoService: CandidatosPorEstadoService, private router: Router) { }

  ngOnInit(): void {
    this.fetchData();
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
          this.candidatosPorEstadoService.allPostData(this.pessoas).subscribe(
            (res: any) => {
              this.pessoas = res;
              console.log("testetsteste", this.pessoas);
              this.fetchData();
            },
            (error: any) => {
              console.error('Erro na requisição:', error);
            }
          );
        } catch (e) {
          console.error('Erro ao parsear o arquivo JSON', e);
        }
      };
      reader.onerror = (evt) => {
        console.error('Erro ao ler arquivo', evt);
      };
    }else{
      console.log("MEU ELSE");
    }
  }


  fetchData(event?: PageEvent): void {
    const page = event ? event.pageIndex : 0;
    const size = event ? event.pageSize : 10;
  
    this.candidatosPorEstadoService.getData(page, size).subscribe(
      (res: any) => {
        console.log('Resposta do servidor:', res);
        if (res && res.content && Array.isArray(res.content) && res.content.every((item: any) => typeof item === 'object')) {
          this.pessoas = res.content;
          this.totalElements = res.totalElements;
          if (this.pessoas.length > 0) {
            this.columns = Object.keys(this.pessoas[0]);
          } else {
            this.columns = [];
          }
          this.prepareTables(this.pessoas);
        } else {
          console.error('Erro: A resposta não contém um array de objetos válido:', res);
        }
      },
      (error: any) => {
        console.error('Erro na requisição:', error);
      }
    );
  } 
  
  prepareTables(pessoas: Pessoa[]): void {

    const table = {
      title: 'Candidatos',
      data: [] as any[]
    };


    if (pessoas.length > 0) {
      console.log("MAIOR");
      table.data.push(Object.keys(pessoas[0]).map(key => [key]));
    }


    pessoas.forEach(pessoa => {
      table.data.push(Object.values(pessoa).map(value => [value]));
    });

    this.tables = [];
    this.tables.push(table);
  }

  excluirCandidato() {
    console.log("Excluindo candidatos...");
    this.candidatosPorEstadoService.deleteAll().subscribe(
      (response) => {        
        this.router.navigate(['/'], { skipLocationChange: true }).then(() => {
          this.router.navigate(['/criar']);
        });
      },
      (error) => {
        console.error("Erro ao excluir candidatos:", error);
      }
    );
  }
  
}