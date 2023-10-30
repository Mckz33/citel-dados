import { MatPaginator } from '@angular/material/paginator';
import { MediaIdadeSanguineoService } from './../../services/media-idade-sanguineo/media-idade-sanguineo.service';
import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { CandidatosPorEstado } from 'src/app/models/candidatos-por-estado';
import { MediaIdadeSanguineo } from 'src/app/models/media-idade-sanguineo';
import { Pessoa } from 'src/app/models/pessoa';
import { CandidatosPorEstadoService } from 'src/app/services/candidatos-por-estados/candidatos-por-estado.service';

@Component({
  selector: 'app-media-idade-sanguineo',
  templateUrl: './media-idade-sanguineo.component.html',
  styleUrls: ['./media-idade-sanguineo.component.css']
})
export class MediaIdadeSanguineoComponent implements AfterViewInit {

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
              this.dataSource = Object.entries(this.resposta.mediaIdadePorTipoSanguineo || {});
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

