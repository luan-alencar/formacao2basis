import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { ConfirmationService, Table } from 'primeng';
import { finalize } from 'rxjs/operators';
import { Responsavel } from 'src/app/dominio/responsavel';
import { DefaultFilter } from 'src/app/shared/model/default-filter';
import { MensagemUtil } from 'src/app/shared/utils/mensagem-util';
import { ResponsavelService } from '../service/responsavel.service';
import { BlockUI, NgBlockUI } from 'ng-block-ui';
import { StatusEnum } from 'src/app/shared/utils/status-enum';


@Component({
  selector: 'app-responsavel-list',
  templateUrl: './responsavel-list.component.html',
  styleUrls: ['./responsavel-list.component.css']
})
export class ResponsavelListComponent implements OnInit {

  @Input() titulo: string;
  @BlockUI() blockUI: NgBlockUI;

  responsaveis: Responsavel[] = [];
  responsavel = new Responsavel();
  exibirDialog = false;
  formularioEdicao: boolean;
  filtro: DefaultFilter;
  dataTable: Table;
  pageResponsavel: import("/home/luan/Documentos/BASIS/formacao2/frontend/src/app/shared/model/page").Page<Responsavel>;

  constructor(
    private service: ResponsavelService,
    private confirmationService: ConfirmationService
  ) { }

  ngOnInit(): void {
    this.buscarTodosResponsaveis();
  }

  private buscarTodosResponsaveis() {
    this.service.buscarTodosResponsaveis()
      .subscribe((responsaveis: Responsavel[]) => {
        this.responsaveis = responsaveis;
      });
  }

  pesquisarResponsavel() {
    this.blockUI.start(MensagemUtil.BLOCKUI_CARREGANDO);
    this.service.pesquisar(this.filtro, this.dataTable)
      .pipe(finalize(() => this.blockUI.stop()))
      .subscribe(page => { this.pageResponsavel = page; });
  }

  mostrarDialog(edicao = false) {
    this.exibirDialog = true;
    this.formularioEdicao = edicao;
  }

  mostrarDialogEditar(id: number) {
    this.service.buscarResponsavelPorId(id)
      .subscribe(responsavel => {
        this.responsavel = responsavel;
        this.mostrarDialog(true);
      })
  }

  fecharDialog(event) {
    this.exibirDialog = false;
    this.buscarTodosResponsaveis();
  }

  confirmarDeletarResponsavel(id?: number) {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir o responsavel?',
      accept: () => {
        this.deletarResponsavel(id);
      }
    });

  }

  deletarResponsavel(id?: number) {
    this.service.deletarResponsavel(id)
      .subscribe(() => {
        alert('Responsavel deletado');
        this.buscarTodosResponsaveis();
      },
        err => alert(err));
  }
}
