import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { CandidatosPorEstado } from 'src/app/models/candidatos-por-estado';
import { DoadoresTipoSanguineo } from 'src/app/models/doadores-tipo-sanguineo';
import { Pessoa } from 'src/app/models/pessoa';
import { CandidatosPorEstadoService } from 'src/app/services/candidatos-por-estados/candidatos-por-estado.service';
import { DoadoresTipoSanguineoService } from 'src/app/services/doadores-tipo-sanguineo/doadores-tipo-sanguineo.service';

@Component({
  selector: 'app-doadores-tipo-sanguineo',
  templateUrl: './doadores-tipo-sanguineo.component.html',
  styleUrls: ['./doadores-tipo-sanguineo.component.css']
})
export class DoadoresTipoSanguineoComponent implements AfterViewInit {

  dataSource: any[] = []; // Todos os dados para exibição
  pagedItems: any[] = []; // Itens da página atual

  candidatosPorEstado: CandidatosPorEstado[] = [];
  public pessoas: Array<Pessoa> = [];
  public resposta!: CandidatosPorEstado;

  displayedColumns = ['Estado', 'Quantidade'];

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
              console.log(this.resposta);
              this.dataSource = Object.entries(this.resposta.possiveisDoadoresPorTipoSanguineo || {});
              this.updatePagedItems(); // Atualiza os itens paginados após carregar os novos dados
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

  // Método para atualizar os itens paginados com base na página atual do paginador
  updatePagedItems(): void {
    const startItem = this.paginator.pageIndex * this.paginator.pageSize;
    const endItem = startItem + this.paginator.pageSize;
    this.pagedItems = this.dataSource.slice(startItem, endItem);
  }
}

