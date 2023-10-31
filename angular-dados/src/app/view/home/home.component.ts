import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { CandidatosPorEstado } from 'src/app/models/candidatos';
import { Pessoa } from 'src/app/models/pessoa';
import { CandidatosPorEstadoService } from 'src/app/services/candidatos-por-estados/candidatos-por-estado.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements AfterViewInit {

  dataSource: any[] = []; // Todos os dados para exibição
  pagedItems: any[] = []; // Itens da página atual

  dataSourceCandidatos: any[] = [];
  dataSourceImcMedio: any[] = [];
  dataSourceMediaIdade: any[] = [];
  dataSourceDoadores: any[] = [];

  candidatosPorEstado: CandidatosPorEstado[] = [];
  public pessoas: Array<Pessoa> = [];
  public resposta!: CandidatosPorEstado;

  constructor(private candidatosPorEstadoService: CandidatosPorEstadoService) { }

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

              // Distribua os dados para diferentes dataSources
              this.dataSourceCandidatos = Object.entries(this.resposta.candidatosPorEstado || {});
              this.dataSourceImcMedio = Object.entries(this.resposta.imcMedioPorFaixaEtaria || {});
              this.dataSourceMediaIdade = Object.entries(this.resposta.mediaIdadePorTipoSanguineo || {});
              this.dataSourceDoadores = Object.entries(this.resposta.possiveisDoadoresPorTipoSanguineo || {});

              this.dataSource = this.dataSourceCandidatos;
              this.updatePagedItems();  
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

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit(): void {
    this.paginator.page.subscribe(() => {
      this.updatePagedItems();
    });
  }

  updatePagedItems(): void {
    const startItem = this.paginator.pageIndex * this.paginator.pageSize;
    const endItem = startItem + this.paginator.pageSize;
    this.pagedItems = this.dataSource.slice(startItem, endItem);
  }

  changeTab(tabIndex: number): void {
    switch (tabIndex) {
      case 0:
        this.dataSource = this.dataSourceCandidatos;
        break;
      case 1:
        this.dataSource = this.dataSourceImcMedio;
        break;
      case 2:
        this.dataSource = this.dataSourceMediaIdade;
        break;
      case 3:
        this.dataSource = this.dataSourceDoadores;
        break;
      default:
        this.dataSource = [];
    }
    this.paginator.length = this.dataSource.length;  // Atualizar o comprimento do paginador
    this.updatePagedItems();
  }
}