import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DoadoresTipoSanguineo } from 'src/app/models/doadores-tipo-sanguineo';

@Injectable({
  providedIn: 'root'
})
export class DoadoresTipoSanguineoService {

  private baseURL = "http://localhost:3000";

  constructor(private httpClient: HttpClient) {}

  get(): Observable<any> {
    return this.httpClient.get<DoadoresTipoSanguineo[]>(`${this.baseURL}/possiveisDoadoresPorTipoSanguineo`)
  }
}
