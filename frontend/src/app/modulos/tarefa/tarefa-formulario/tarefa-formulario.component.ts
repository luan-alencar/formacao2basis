import { HttpErrorResponse } from '@angular/common/http';
import { Input } from '@angular/core';
import { Output } from '@angular/core';
import { Component, EventEmitter, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Tarefa } from 'src/app/dominio/tarefa';
import { TarefaService } from '../service/tarefa.service';

@Component({
  selector: 'app-tarefa-formulario',
  templateUrl: './tarefa-formulario.component.html',
  styleUrls: ['./tarefa-formulario.component.css']
})
export class TarefaFormularioComponent implements OnInit {

  @Input() tarefa = new Tarefa();
  @Input() edicao = false;
  @Output() tarefaSalva = new EventEmitter<Tarefa>();

  formTarefa: FormGroup;

  constructor(
    private fb: FormBuilder,
    private service: TarefaService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      if (params.id) {
        this.edicao = true;
        this.buscarTarefaPorId(params.id);
      }
    });

    this.formTarefa = this.fb.group({
      nome: ['', Validators.minLength(3)],
      email: '',
      dataNascimento: '',
      tarefas: ''
    })
  }


  buscarTarefaPorId(id: number) {
    this.service.buscarTarefaPorId(id)
      .subscribe(tarefa => { this.tarefa = tarefa; });
  }


  salvar() {
    if (this.formTarefa.invalid) {
      alert('Formulário inválido');
      return;
    }

    if (this.edicao) {
      this.service.editarTarefa(this.tarefa)
        .subscribe(tarefa => {
          alert('Tarefa Editada');
          this.fecharDialog(tarefa);
        }, (erro: HttpErrorResponse) => {
          alert(erro.error.message);
        });
    }
    this.service.salvarTarefa(this.tarefa)
      .subscribe(tarefa => {
        alert('Tarefa Salvo');
        this.fecharDialog(tarefa);
      }, (erro: HttpErrorResponse) => {
        alert(erro.error.message);
      });
  }

  fecharDialog(tarefaSalva: Tarefa) {
    this.tarefaSalva.emit(tarefaSalva);
  }
}
