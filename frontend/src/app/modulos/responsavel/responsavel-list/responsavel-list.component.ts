import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { ConfirmationService, Table } from 'primeng';
import { Responsavel } from 'src/app/dominio/responsavel';
import { DefaultFilter } from 'src/app/shared/model/default-filter';
import { ResponsavelService } from '../service/responsavel.service';
import { BlockUI, NgBlockUI } from 'ng-block-ui';
import { Page } from 'src/app/shared/model/page';
import { ViewChild } from '@angular/core';


@Component({
  selector: 'app-responsavel-list',
  templateUrl: './responsavel-list.component.html',
  styleUrls: ['./responsavel-list.component.css']
})
export class ResponsavelListComponent implements OnInit {

  @Input() titulo: string;
  @BlockUI() blockUI: NgBlockUI;
  @ViewChild(Table) set ft(dataTable: Table) {
    console.log(dataTable);
    this.ft = dataTable ;
  }

  // @ViewChild(Table, {static: false}) dataTable: Table;

  responsavel = new Responsavel();
  exibirDialog = false;
  formularioEdicao: boolean;
  filtro = new DefaultFilter();
  pageResponsavel: Page<Responsavel> = new Page<Responsavel>();
  responsaveis: Responsavel[] = [];

  constructor(
    private service: ResponsavelService,
    private confirmationService: ConfirmationService
  ) { }

  ngOnInit(): void {
    this.buscarTodosResponsaveis();
  }

  private buscarTodosResponsaveis() {
    
    console.log(this.ft)
    this.service.buscarTodosResponsaveis()
      .subscribe((responsaveis: Responsavel[]) => {
        this.responsaveis = responsaveis;
      });
  }

  pesquisarResponsavel() {
    debugger
    console.log(this.ft)
    this.service.pesquisar(this.filtro, this.ft)
      .subscribe(res => { this.pageResponsavel = res; });
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
