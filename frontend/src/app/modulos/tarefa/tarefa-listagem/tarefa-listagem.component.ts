import { Component, OnInit } from '@angular/core';
import { Table } from 'primeng';
import { Anexo } from 'src/app/dominio/anexo';
import { Responsavel } from 'src/app/dominio/responsavel';
import { Tarefa } from 'src/app/dominio/tarefa';
import { DefaultFilter } from 'src/app/shared/model/default-filter';
import { Page } from 'src/app/shared/model/page';
import { TarefaService } from '../service/tarefa.service';
import { BlockUI, NgBlockUI } from 'ng-block-ui';
import { MensagemUtil } from 'src/app/shared/utils/mensagem-util';
import { finalize } from 'rxjs/operators';
import { StatusEnum } from 'src/app/shared/utils/status-enum';



@Component({
  selector: 'app-tarefa-listagem',
  templateUrl: './tarefa-listagem.component.html',
  styleUrls: ['./tarefa-listagem.component.css']
})
export class TarefaListagemComponent implements OnInit {

  @BlockUI() blockUI: NgBlockUI;

  tarefaFiltro: DefaultFilter;
  tarefaSelecionada: Tarefa;
  formularioEdicao: boolean;
  loading: boolean = true;
  tarefa = new Tarefa();
  exibirDialog = false;
  dataTable: Table;

  pageTarefas: Page<Tarefa> = new Page<Tarefa>();
  activityValues: number[] = [0, 100];
  responsaveis: Responsavel[] = [];
  tarefas: Tarefa[] = [];
  anexos: Anexo[] = [];

  constructor(private service: TarefaService) { }

  ngOnInit(): void {
    this.buscarTodasTarefas();
    this.pesquisarTarefa();
  }

  private buscarTodasTarefas() {
    this.service.buscarTodasTarefas()
      .subscribe((tarefa: Tarefa[]) => {
        this.tarefas = tarefa;
      });
  }

  pesquisarTarefa() {
    this.blockUI.start(MensagemUtil.BLOCKUI_CARREGANDO);
    this.service.pesquisar(this.tarefaFiltro, this.dataTable)
      .pipe(finalize(() => this.blockUI.stop()))
      .subscribe(page => { this.pageTarefas = page; });
  }

  statusTarefa(status: boolean): string {
    if (status == true) {
      return StatusEnum.ATIVO;
    }
    return StatusEnum.INATIVO
  }

  fecharDialog(event) {
    this.exibirDialog = false;
    this.buscarTodasTarefas();
  }

}
