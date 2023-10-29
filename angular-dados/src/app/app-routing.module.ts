import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CandidatoPorEstadoComponent } from './components/candidato-por-estado/candidato-por-estado.component';
import { ImcMedioFaixaEtariaComponent } from './components/imc-medio-faixa-etaria/imc-medio-faixa-etaria.component';
import { HomeComponent } from './view/home/home.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "candidatos-por-estados", component: CandidatoPorEstadoComponent},
  {path: "imc-faixa-etaria", component: ImcMedioFaixaEtariaComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
