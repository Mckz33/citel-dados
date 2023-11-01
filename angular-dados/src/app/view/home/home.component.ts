import { AfterViewInit, Component, ViewChild, OnInit } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { Pessoa } from 'src/app/models/pessoa';
import { CandidatosPorEstadoService } from 'src/app/services/candidatos-por-estados/candidatos-por-estado.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements AfterViewInit, OnInit {

  dataSource: { key: string, value: number }[] = [];

  candidatosPorEstado: { key: string, value: number }[] = [];
  imcMedioPorFaixaEtaria: { key: string, value: number }[] = [];
  percentualObesosHomens: number = 0;
  percentualObesosMulheres: number = 0;
  mediaIdadePorTipoSanguineo: { key: string, value: number }[] = [];
  possiveisDoadoresPorTipoSanguineo: { key: string, value: number }[] = [];

  // Listas para itens paginados
  currentCandidatosPorEstado: { key: string, value: number }[] = [];
  currentImcMedioPorFaixaEtaria: { key: string, value: number }[] = [];
  currentMediaIdadePorTipoSanguineo: { key: string, value: number }[] = [];
  currentPossiveisDoadoresPorTipoSanguineo: { key: string, value: number }[] = [];

  public pessoas: Array<Pessoa> = [];
  public resposta: any;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private candidatosPorEstadoService: CandidatosPorEstadoService) { }
  ngOnInit(): void {
    this.process();
  }

  process(){
          this.candidatosPorEstadoService.getDataValue().subscribe(
            (res: any) => {
              this.resposta = res;
              console.log(this.resposta);
              this.prepareData(this.resposta);
            },
            (error: any) => {
              console.error('Erro na requisição:', error);
            }
          );
     
      }

  ngAfterViewInit(): void {
    this.paginator.page.subscribe(() => {
      this.updatePagedItems();
    });
  }

  updatePagedItems(): void {
    const startItem = this.paginator.pageIndex * this.paginator.pageSize;
    const endItem = startItem + this.paginator.pageSize;
    this.currentCandidatosPorEstado = this.candidatosPorEstado.slice(startItem, endItem);
    this.currentImcMedioPorFaixaEtaria = this.imcMedioPorFaixaEtaria.slice(startItem, endItem);
    this.currentMediaIdadePorTipoSanguineo = this.mediaIdadePorTipoSanguineo.slice(startItem, endItem);
    this.currentPossiveisDoadoresPorTipoSanguineo = this.possiveisDoadoresPorTipoSanguineo.slice(startItem, endItem);
  }

  prepareData(resposta: any): void {
    if (resposta) {
      this.candidatosPorEstado = Object.entries(resposta.resultados.CandidatosPorEstado || {}).map(([key, value]) => ({ key, value: Number(value) }));
      this.imcMedioPorFaixaEtaria = Object.entries(resposta.resultados.EstatisticaIMCMedioPorFaixaEtaria || {}).map(([key, value]) => ({ key, value: Number(value) }));
      this.percentualObesosHomens = Number(resposta.resultados.EstatisticaObesidadePorGenero.PercentualObesosHomens);
      this.percentualObesosMulheres = Number(resposta.resultados.EstatisticaObesidadePorGenero.PercentualObesosMulheres);
      this.mediaIdadePorTipoSanguineo = Object.entries(resposta.resultados.EstatisticaMediaIdadePorTipoSanguineo || {}).map(([key, value]) => ({ key, value: Number(value) }));
      this.possiveisDoadoresPorTipoSanguineo = Object.entries(resposta.resultados.PossiveisDoadoresPorTipoSanguineo || {}).map(([key, value]) => ({ key, value: Number(value) }));

      this.dataSource = [...this.candidatosPorEstado, ...this.imcMedioPorFaixaEtaria, ...this.mediaIdadePorTipoSanguineo, ...this.possiveisDoadoresPorTipoSanguineo];
      this.updatePagedItems();
    } else {
      console.error('Resposta inesperada:', resposta);
    }
  }
}
