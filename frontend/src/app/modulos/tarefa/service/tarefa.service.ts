import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tarefa } from 'src/app/dominio/tarefa';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TarefaService {

  url = `${environment.apiUrl}/tarefas`;

  constructor(private http: HttpClient) { }

  buscarTarefaPorId(id: number): Observable<Tarefa> {
    return this.http.get<Tarefa>(`${this.url}/${id}`);
  }

  buscarTodasTarefas(): Observable<Tarefa[]> {
    return this.http.get<Tarefa[]>(`${this.url}`);
  }

  salvarTarefa(tarefa: Tarefa): Observable<Tarefa> {
    return this.http.post<Tarefa>(this.url, tarefa);
  }

  editarTarefa(tarefa: Tarefa): Observable<Tarefa> {
    return this.http.put<Tarefa>(this.url, tarefa);
  }

  deletarTarefa(id: number): Observable<any> {
    return this.http.delete<Tarefa>(`${this.url}/${id}`);
  }

}
