import { Pessoa } from './../../models/pessoa';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CandidatosPorEstado } from 'src/app/models/candidatos';

@Injectable({
  providedIn: 'root'
})
export class CandidatosPorEstadoService {

  private baseURL = "http://localhost:8080";

  constructor(private httpClient: HttpClient) { }


  postData(pessoas: Array<Pessoa>) {
    const url = `${this.baseURL}/imc`;
    return this.httpClient.post(url, pessoas);
  }
}