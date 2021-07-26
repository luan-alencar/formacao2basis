import { HttpErrorResponse } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Responsavel } from 'src/app/dominio/responsavel';
import { ResponsavelService } from '../service/responsavel.service';

@Component({
  selector: 'app-responsavel-form',
  templateUrl: './responsavel-form.component.html',
  styleUrls: ['./responsavel-form.component.css']
})
export class ResponsavelFormComponent implements OnInit {

  @Input() responsavel = new Responsavel();
  @Input() edicao = false;
  @Output() responsavelSalvo = new EventEmitter<Responsavel>();

  formResponsavel: FormGroup;

  constructor(
    private fb: FormBuilder,
    private service: ResponsavelService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      if (params.id) {
        this.edicao = true;
        this.buscarResponsavelPorId(params.id);
      }
    });

    this.formResponsavel = this.fb.group({
      nome: ['', Validators.minLength(3)],
      email: '',
      dataNascimento: '',
      tarefas: ''
    })
  }


  buscarResponsavelPorId(id: number) {
    this.service.buscarResponsavelPorId(id)
      .subscribe(responsavel => { this.responsavel = responsavel; });
  }


  salvar() {
    if (this.formResponsavel.invalid) {
      alert('Formulário inválido');
      return;
    }

    if (this.edicao) {
      this.service.editarResponsavel(this.responsavel)
        .subscribe(responsavel => {
          alert('Responsavel Editado');
          this.fecharDialog(responsavel);
        }, (erro: HttpErrorResponse) => {
          alert(erro.error.message);
        });
    }
    this.service.salvarResponsavel(this.responsavel)
      .subscribe(responsavel => {
        alert('Responsavel Salvo');
        this.fecharDialog(responsavel);
      }, (erro: HttpErrorResponse) => {
        alert(erro.error.message);
      });
  }

  fecharDialog(responsavelSalvo: Responsavel) {
    this.responsavelSalvo.emit(responsavelSalvo);
  }

}
