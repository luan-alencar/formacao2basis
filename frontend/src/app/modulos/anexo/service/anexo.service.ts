import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Table } from 'primeng';
import { Observable } from 'rxjs';
import { Anexo } from 'src/app/dominio/anexo';
import { Tarefa } from 'src/app/dominio/tarefa';
import { DefaultFilter } from 'src/app/shared/model/default-filter';
import { Page } from 'src/app/shared/model/page';
import { RequestUtils } from 'src/app/shared/utils/request-utils';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AnexoService {

  url = `${environment.apiUrl}/tarefas`;

  constructor(private http: HttpClient) { }

  buscarAnexoPorId(id: number): Observable<Tarefa> {
    return this.http.get<Tarefa>(`${this.url}/${id}`);
  }

  buscarTodosAnexos(): Observable<Anexo[]> {
    return this.http.get<Anexo[]>(`${this.url}`);
  }

  salvarAnexo(anexo: Anexo): Observable<Anexo> {
    return this.http.post<Anexo>(this.url, anexo);
  }

  editarAnexo(anexo: Anexo): Observable<Anexo> {
    return this.http.put<Anexo>(this.url, anexo);
  }

  deletarAnexo(id: number): Observable<any> {
    return this.http.delete<Anexo>(`${this.url}/${id}`);
  }

  pesquisar(filter: DefaultFilter, dataTable: Table): Observable<Page<Anexo>> {
    return this.http.post<Page<Anexo>>(`${this.url}/pesquisar`, filter, {
      params: RequestUtils.getRequestParamsTable(dataTable)
    });
  }
}
