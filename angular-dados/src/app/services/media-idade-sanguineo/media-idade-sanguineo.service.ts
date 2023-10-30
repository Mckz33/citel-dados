import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MediaIdadeSanguineo } from 'src/app/models/media-idade-sanguineo';

@Injectable({
  providedIn: 'root'
})
export class MediaIdadeSanguineoService {

  private baseURL = "http://localhost:3000";

  constructor(private httpClient: HttpClient) {}

  get(): Observable<any> {
    return this.httpClient.get<MediaIdadeSanguineo[]>(`${this.baseURL}/mediaIdadePorTipoSanguineo`)
  }
}