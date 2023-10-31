import { Pessoa } from './../../models/pessoa';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CandidatosPorEstadoService {

  private baseURL = "http://localhost:8080";

  constructor(private httpClient: HttpClient) { }

  postData(pessoas: Array<Pessoa>) {
    const url = `${this.baseURL}/imc`;
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.httpClient.post(url, pessoas, {headers: headers});
  }

  getAll() {
    return this.httpClient.get<Pessoa[]>(this.baseURL)
  }
}