import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CandidatoPorEstadoComponent } from './components/candidato-por-estado/candidato-por-estado.component';
import { RouterModule } from '@angular/router';
import { ImcMedioFaixaEtariaComponent } from './components/imc-medio-faixa-etaria/imc-medio-faixa-etaria.component';
import { HeaderComponent } from './template/header/header.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { NavComponent } from './template/nav/nav.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from "@angular/material/list";
import { MatCardModule } from "@angular/material/card";
import { MatButtonModule } from "@angular/material/button";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { FooterComponent } from './template/footer/footer.component';
import { ListarCandidatosBrasilComponent } from './view/listar-candidatos-brasil/listar-candidatos-brasil.component';
import { HomeComponent } from './view/home/home.component';


@NgModule({
  declarations: [
    AppComponent,
    CandidatoPorEstadoComponent,
    ImcMedioFaixaEtariaComponent,
    HeaderComponent,
    NavComponent,
    FooterComponent,
    ListarCandidatosBrasilComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    RouterModule,
    MatCardModule,
    MatButtonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatInputModule,
    FormsModule,
    MatFormFieldModule,
    MatSnackBarModule,
    MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
