import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
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

  public resposta: any;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private candidatosPorEstadoService: CandidatosPorEstadoService) { }

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
              this.resposta = res;
              console.log(this.resposta);
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
    }
  }


  fetchData(event?: PageEvent): void {
    const page = event ? event.pageIndex : 0;
    const size = event ? event.pageSize : 20;

    this.candidatosPorEstadoService.getData(page, size).subscribe(
      (res: any) => {
        console.log('Resposta do servidor:', res);
        if (res && Array.isArray(res.content) && res.content.every((item: any) => typeof item === 'object')) {
          this.pessoas = res.content;
          this.totalElements = res.totalElements;
          if (this.pessoas.length > 0) {
            this.columns = Object.keys(this.pessoas[0]);
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
    // Criando uma tabela para exibir as informações dos candidatos
    const table = {
      title: 'Candidatos',
      data: [] as any[]
    };
  
    // Adicionando os cabeçalhos das colunas
    if (pessoas.length > 0) {
      table.data.push(Object.keys(pessoas[0]).map(key => [key]));
    }
  
    // Adicionando os dados dos candidatos
    pessoas.forEach(pessoa => {
      table.data.push(Object.values(pessoa).map(value => [value]));
    });
  
    // Limpando a lista de tabelas antes de adicionar a nova tabela
    this.tables = [];
    
    // Adicionando a tabela criada à lista de tabelas
    this.tables.push(table);
  }
}