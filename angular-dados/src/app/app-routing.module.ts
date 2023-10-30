import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CandidatoPorEstadoComponent } from './components/candidato-por-estado/candidato-por-estado.component';
import { ImcMedioFaixaEtariaComponent } from './components/imc-medio-faixa-etaria/imc-medio-faixa-etaria.component';
import { HomeComponent } from './view/home/home.component';
import { ObesosGeneroComponent } from './components/obesos-genero/obesos-genero.component';
import { MediaIdadeSanguineoComponent } from './components/media-idade-sanguineo/media-idade-sanguineo.component';
import { DoadoresTipoSanguineoComponent } from './components/doadores-tipo-sanguineo/doadores-tipo-sanguineo.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "candidatos-por-estados", component: CandidatoPorEstadoComponent},
  {path: "imc-faixa-etaria", component: ImcMedioFaixaEtariaComponent},
  {path: "obesos-genero", component: ObesosGeneroComponent},
  {path: "media-idade-sanguineo", component: MediaIdadeSanguineoComponent},
  {path: "doadores-tipo-sanguineo", component: DoadoresTipoSanguineoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
