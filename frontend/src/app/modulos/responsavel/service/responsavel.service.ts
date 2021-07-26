import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Responsavel } from 'src/app/dominio/responsavel';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ResponsavelService {

  url = `${environment.apiUrl}/responsaveis`;

  constructor(private http: HttpClient) { }

  buscarResponsavelPorId(id: number): Observable<Responsavel> {
    return this.http.get<Responsavel>(`${this.url}/${id}`);
  }

  buscarTodosResponsaveis(): Observable<Responsavel[]> {
    return this.http.get<Responsavel[]>(`${this.url}`);
  }

  salvarResponsavel(responsavel: Responsavel): Observable<Responsavel> {
    return this.http.post<Responsavel>(this.url, responsavel);
  }

  editarResponsavel(responsavel: Responsavel): Observable<Responsavel> {
    return this.http.put<Responsavel>(this.url, responsavel);
  }

  deletarResponsavel(id: number): Observable<any> {
    return this.http.delete<Responsavel>(`${this.url}/${id}`);
  }
}
