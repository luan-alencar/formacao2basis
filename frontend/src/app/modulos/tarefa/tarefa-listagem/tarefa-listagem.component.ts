import { Component, OnInit } from '@angular/core';
import { Anexo } from 'src/app/dominio/anexo';
import { Responsavel } from 'src/app/dominio/responsavel';
import { Tarefa } from 'src/app/dominio/tarefa';
import { TarefaService } from '../service/tarefa.service';

@Component({
  selector: 'app-tarefa-listagem',
  templateUrl: './tarefa-listagem.component.html',
  styleUrls: ['./tarefa-listagem.component.css']
})
export class TarefaListagemComponent implements OnInit {

  tarefas: Tarefa[] = [];
  
  tarefa = new Tarefa();

  exibirDialog = false;

  responsaveis: Responsavel[] = [];

  formularioEdicao: boolean;

  anexos: Anexo[] = [];

  statuses: any[];

  loading: boolean = true;

  activityValues: number[] = [0, 100];

  constructor(private service: TarefaService) { }

  ngOnInit() {
    this.buscarTodasTarefas();
  }

  private buscarTodasTarefas() {
    this.service.buscarTodasTarefas()
      .subscribe((tarefa: Tarefa[]) => {
        this.tarefas = tarefa;
      });
  }

  fecharDialog(event) {
    this.exibirDialog = false;
    this.buscarTodasTarefas();
  }
}
