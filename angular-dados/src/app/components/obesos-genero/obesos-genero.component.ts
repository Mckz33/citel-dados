import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { CandidatosPorEstado } from 'src/app/models/candidatos-por-estado';
import { ObesosGenero } from 'src/app/models/obesos-genero';
import { Pessoa } from 'src/app/models/pessoa';
import { CandidatosPorEstadoService } from 'src/app/services/candidatos-por-estados/candidatos-por-estado.service';

@Component({
  selector: 'app-obesos-genero',
  templateUrl: './obesos-genero.component.html',
  styleUrls: ['./obesos-genero.component.css']
})
export class ObesosGeneroComponent implements AfterViewInit {

  dataSource: any[] = []; // Todos os dados para exibição
  pagedItems: any[] = []; // Itens da página atual

  candidatosPorEstado: CandidatosPorEstado[] = [];
  public pessoas: Array<Pessoa> = [];
  public resposta!: CandidatosPorEstado;

  displayedColumns = ['Estado', 'Quantidade'];

  constructor(private candidatosPorEstadoService: CandidatosPorEstadoService) { }

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit(): void {
    this.loadDataFromCookie();
    this.paginator.page.subscribe(() => {
      this.updatePagedItems();
    });
  }

  loadDataFromCookie(): void {
    const cookieData = this.getSessionCookie("myJsonData");
    if (cookieData) {
      const jsonData = JSON.parse(cookieData);
      this.pessoas = jsonData;
      this.candidatosPorEstadoService.postData(this.pessoas).subscribe(
        (res: any) => {
          this.resposta = res;
          this.dataSource = Object.entries(this.resposta.candidatosPorEstado || {});
          this.updatePagedItems();
        }
      );
    }
  }

  getSessionCookie(name: string): string | null {
    const nameEQ = name + "=";
    const ca = document.cookie.split(';');
    for(let i=0;i < ca.length;i++) {
        let c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return decodeURIComponent(c.substring(nameEQ.length,c.length));
    }
    return null;
  }

  // Método para atualizar os itens paginados com base na página atual do paginador
  updatePagedItems(): void {
    const startItem = this.paginator.pageIndex * this.paginator.pageSize;
    const endItem = startItem + this.paginator.pageSize;
    this.pagedItems = this.dataSource.slice(startItem, endItem);
  }
}