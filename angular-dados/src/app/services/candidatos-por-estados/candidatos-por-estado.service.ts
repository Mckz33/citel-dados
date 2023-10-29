import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CandidatosPorEstado } from 'src/app/models/candidatos-por-estado';

@Injectable({
  providedIn: 'root'
})
export class CandidatosPorEstadoService {

  private baseURL = "http://localhost:3000";

  constructor(private httpClient: HttpClient) {}

  get() {
    return this.httpClient.get<CandidatosPorEstado[]>(`${this.baseURL}/candidatosPorEstado`)
  }
}