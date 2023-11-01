import { Pessoa } from './../../models/pessoa';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CandidatosPorEstadoService {

  private baseURL = "http://localhost:8080";

  constructor(private httpClient: HttpClient) { }

  postData(pessoas: Array<Pessoa>) {
    const url = `${this.baseURL}/candidato`;
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.httpClient.post(url, pessoas, {headers: headers});
  }

  getDataValue(): Observable<any> {
    const url = `${this.baseURL}/estatisticas/gerar`;
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.httpClient.get(url, { headers });
  }

  allPostData(pessoas: Array<Pessoa>) {
    const url = `${this.baseURL}/candidato/save-all`;
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.httpClient.post(url, pessoas, {headers: headers});
  }

  getData(page: number = 0, size: number = 10): Observable<Pessoa[]> {
    return this.httpClient.get<Pessoa[]>(`${this.baseURL}/candidato?page=${page}&size=${size}`);
  }

  deleteAll(){
    return this.httpClient.delete(`${this.baseURL}/candidato`)
    .pipe(
      catchError((error: any) => {
        console.error('Erro na solicitação DELETE:', error);
        throw error; // Você pode personalizar a manipulação de erros aqui
      })
    );
  }

}
