import { Input } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { ConfirmationService } from 'primeng';
import { Responsavel } from 'src/app/dominio/responsavel';
import { ResponsavelService } from '../service/responsavel.service';

@Component({
  selector: 'app-responsavel-list',
  templateUrl: './responsavel-list.component.html',
  styleUrls: ['./responsavel-list.component.css']
})
export class ResponsavelListComponent implements OnInit {

  @Input() titulo: string;

  responsaveis: Responsavel[] = [];
  responsavel = new Responsavel();
  exibirDialog = false;
  formularioEdicao: boolean;

  constructor(
    private service: ResponsavelService,
    private confirmationService: ConfirmationService
  ) { }

  ngOnInit(): void {
    this.buscarTodosResponsaveis();
  }

  private buscarTodosResponsaveis() {
    this.service.buscarTodosUsuario()
      .subscribe(responsavel => {
        this.responsaveis = responsavel;
        this.mostrarDialog(true);
      });
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
    this.service.deletarResponsavel(id)
      .subscribe(() => {
        alert('Responsavel deletado');
        this.buscarTodosResponsaveis();
      },
        err => alert(err));
  }
}
