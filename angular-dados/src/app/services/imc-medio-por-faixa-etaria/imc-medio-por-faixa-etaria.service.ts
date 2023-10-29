import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ImcFaixaEtaria } from 'src/app/models/imc-faixa-etaria';

@Injectable({
  providedIn: 'root'
})
export class ImcMedioPorFaixaEtariaService {

  private baseURL = "http://localhost:3000";

  constructor(private httpClient: HttpClient) {}

  get(): Observable<any> {
    return this.httpClient.get<ImcFaixaEtaria[]>(`${this.baseURL}/imcMedioPorFaixaEtaria`)
  }
}
