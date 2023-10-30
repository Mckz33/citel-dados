import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ObesosGenero } from 'src/app/models/obesos-genero';

@Injectable({
  providedIn: 'root'
})
export class ObesosGeneroService {

  private baseURL = "http://localhost:3000";

  constructor(private httpClient: HttpClient) {}

  get(): Observable<any> {
    return this.httpClient.get<ObesosGenero[]>(`${this.baseURL}/ObesosGenero`)
  }
}